package com.example.crowdfunding.projects;

import com.example.crowdfunding.categories.Categories;
import com.example.crowdfunding.categories.CategoriesService;
import com.example.crowdfunding.members.Member;
import com.example.crowdfunding.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final MemberService memberService;
    private final CategoriesService categoriesService;

    @Autowired
    public ProjectService(
            ProjectRepository projectRepository,
            MemberService memberService,
            CategoriesService categoriesService
    ) {
        this.projectRepository = projectRepository;
        this.memberService = memberService;
        this.categoriesService = categoriesService;
    }

    public Project createProject(Project project, Long memberId, Long categoryId) {
        project.setStatus(ProjectStatus.PENDING);
        // Check if the member and category exist
        Optional<Member> member = memberService.getMemberById(memberId);
        Optional<Categories> category = categoriesService.getCategoryById(categoryId);

        if (member.isPresent() && category.isPresent()) {
            project.setMember(member.get());
            project.setCategory(category.get());

            // Other logic to create the project if needed
            return projectRepository.save(project);
        } else {
            // Handle case where member or category does not exist
            throw new IllegalArgumentException("Member or category not found");
        }
    }

    // ProjectStatus
    public void updateProjectStatus(Long projectId, ProjectStatus newStatus) {
        Project existingProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalStateException("Project not found"));

        // Update the project status
        existingProject.setStatus(newStatus);

        // Save the updated project
        projectRepository.save(existingProject);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public void updateProject(Long id, Project project) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Project not found"));

        // Update fields as needed
        existingProject.setProjectName(project.getProjectName());
        // ... update other fields

        projectRepository.save(existingProject);
    }
}
