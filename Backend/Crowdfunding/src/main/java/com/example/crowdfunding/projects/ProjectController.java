package com.example.crowdfunding.projects;

import com.example.crowdfunding.categories.Categories;
import com.example.crowdfunding.categories.CategoriesService;
import com.example.crowdfunding.members.Member;
import com.example.crowdfunding.members.MemberService;
import com.example.crowdfunding.ProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final MemberService memberService;
    private final CategoriesService categoriesService;

    @Autowired
    public ProjectController(ProjectService projectService, MemberService memberService, CategoriesService categoriesService) {
        this.projectService = projectService;
        this.memberService = memberService;
        this.categoriesService = categoriesService;
    }

    @PostMapping("/addProject")
    public ResponseEntity<String> createProject(@RequestBody ProjectRequest projectRequest) {
        Long memberId = projectRequest.getMemberId();
        Long categoryId = projectRequest.getCategoryId();

        Optional<Member> member = memberService.getMemberById(memberId);
        Optional<Categories> category = categoriesService.getCategoryById(categoryId);

        if (member.isPresent() && category.isPresent()) {
            Project project = projectRequest.getProject();

            // Corrected: Provide member_id and category_id
            projectService.createProject(project, memberId, categoryId);

            return ResponseEntity.status(HttpStatus.CREATED).body("Project created successfully");
        } else {
            // Handle case where member or category does not exist
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Member or category not found");
        }
    }

    @PostMapping("/submit-for-approval/{projectId}")
    public ResponseEntity<String> submitForApproval(@PathVariable Long projectId) {
        projectService.updateProjectStatus(projectId, ProjectStatus.PENDING);
        return ResponseEntity.ok("Project submitted for approval");
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody Project project) {
        projectService.updateProject(id, project);
    }
}
