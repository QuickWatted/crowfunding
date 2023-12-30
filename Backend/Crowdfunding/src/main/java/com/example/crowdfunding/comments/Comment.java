package com.example.crowdfunding.comments;

import com.example.crowdfunding.members.Member;
import com.example.crowdfunding.projects.Project;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCE_COMMENTS")
    @SequenceGenerator(name = "SEQUENCE_COMMENTS", sequenceName = "comments_comment_id_seq", allocationSize = 1)
    private Long commentId;

    private String commentText;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
}
