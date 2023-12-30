package com.example.crowdfunding;

import com.example.crowdfunding.projects.Project;

public class ProjectRequest {
    private Long memberId;
    private Long categoryId;
    private Project project;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectRequest(Long memberId, Long categoryId, Project project) {
        this.memberId = memberId;
        this.categoryId = categoryId;
        this.project = project;
    }
}
