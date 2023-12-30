package com.example.crowdfunding.discussions;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "discussions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCE_DISCUSSION")
    @SequenceGenerator(name = "SEQUENCE_DISCUSSION", sequenceName = "discussions_discussion_id_seq", allocationSize = 1)
    private Long discussionId;

    @Column(name = "messageText")
    private String messageText;

    @Column(name = "messageDate")
    private Date messageDate;

    @Column(name = "adminId")
    private Long adminId;

    @Column(name = "memberId")
    private Long memberId;
}
