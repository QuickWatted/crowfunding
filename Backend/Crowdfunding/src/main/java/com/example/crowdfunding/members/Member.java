package com.example.crowdfunding.members;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCE_MEMBERS")
    @SequenceGenerator(name = "SEQUENCE_MEMBERS", sequenceName = "members_member_id_seq", allocationSize = 1)
    private Long memberId;


    private String firstName;


    private String lastName;

    private String city;
    private String state;
    private String email;
    private String password;

    private String phoneNumber;
}
