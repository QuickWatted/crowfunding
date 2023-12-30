package com.example.crowdfunding.discussions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private Long memberId;
    private String messageText;
}