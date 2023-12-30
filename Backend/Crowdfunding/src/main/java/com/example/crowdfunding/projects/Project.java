package com.example.crowdfunding.projects;

import com.example.crowdfunding.categories.Categories;
import com.example.crowdfunding.members.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCE_PROJECT")
    @SequenceGenerator(name = "SEQUENCE_PROJECT", sequenceName = "projects_project_id_seq", allocationSize = 1)
    private Long projectId;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "projectDescription")
    private String projectDescription;

    @Column(name = "project_deadline")
    private String projectDeadline;

    private String imageUrl;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "isClosed")
    private boolean isClosed;

    @Column(name = "fundsContributed")
    private double fundsContributed;

    @Column(name = "fundsToRaise")
    private double fundsToRaise;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "categoryName")
    private Categories category;
}
