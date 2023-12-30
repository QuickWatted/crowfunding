package com.example.crowdfunding.discussions;


import com.example.crowdfunding.admins.Admin;
import com.example.crowdfunding.admins.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/discussions")
public class DiscussionController {

    private final DiscussionService discussionService;
    private final AdminService adminService;

    @Autowired
    public DiscussionController(DiscussionService discussionService, AdminService adminService) {
        this.discussionService = discussionService;
        this.adminService = adminService;
    }

    @PostMapping
    public void createDiscussion(@RequestBody Discussion discussion) {
        discussionService.createDiscussion(discussion);
    }

    @GetMapping
    public List<Discussion> getAllDiscussions() {
        return discussionService.getAllDiscussions();
    }

    @GetMapping("/{id}")
    public Optional<Discussion> getDiscussionById(@PathVariable("id") Long id) {
        return discussionService.getDiscussionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscussion(@PathVariable("id") Long id) {
        discussionService.deleteDiscussion(id);
    }

    @PutMapping("/{id}")
    public void updateDiscussion(@PathVariable("id") Long id, @RequestBody Discussion discussion) {
        discussionService.updateDiscussion(id, discussion);
    }
    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessageToAdmin(@RequestBody MessageDTO messageDTO) {
        Long adminId = 1L;
        Optional<Admin> admin = Optional.ofNullable(adminService.getAdminById(adminId));

        if (admin.isPresent()) {
            // Create a discussion object with the message and admin details
            Discussion discussion = new Discussion();
            discussion.setMemberId(messageDTO.getMemberId());
            discussion.setMessageText(messageDTO.getMessageText());
            discussion.setAdminId(adminId);

            // Save the discussion to the database
            discussionService.createDiscussion(discussion);

            return ResponseEntity.ok("Message sent successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
        }
    }
}