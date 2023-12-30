package com.example.crowdfunding.discussions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    @Autowired
    public DiscussionService(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    public void createDiscussion(Discussion discussion) {
        discussionRepository.save(discussion);
    }

    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    public Optional<Discussion> getDiscussionById(Long id) {
        return discussionRepository.findById(id);
    }

    public void deleteDiscussion(Long id) {
        discussionRepository.deleteById(id);
    }

    public void updateDiscussion(Long id, Discussion discussion) {
        Discussion existingDiscussion = discussionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Discussion not found"));
        // Update fields as needed
        existingDiscussion.setMessageText(discussion.getMessageText());
        existingDiscussion.setMessageDate(discussion.getMessageDate());
        // ... update other fields
        discussionRepository.save(existingDiscussion);
    }
}