package com.example.crowdfunding.projects;

import java.util.Date;

public class ProjectDto {
    private String projectName;
    private String projectDescription;
    private String projectDeadline;
    private String imageUrl; // This will store the URL of the image
    private Date startDate;
    private double fundsToRaise;

    // Constructors, getters, and setters

    public ProjectDto() {
        // Default constructor
    }

    public ProjectDto(String projectName, String projectDescription, String projectDeadline, String imageUrl, Date startDate, double fundsToRaise) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectDeadline = projectDeadline;
        this.imageUrl = imageUrl;
        this.startDate = startDate;
        this.fundsToRaise = fundsToRaise;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(String projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getFundsToRaise() {
        return fundsToRaise;
    }

    public void setFundsToRaise(double fundsToRaise) {
        this.fundsToRaise = fundsToRaise;
    }
}
