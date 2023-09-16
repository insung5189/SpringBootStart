package com.example.sbb.chatbot.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatRequest {
    private String message;
    private String csrf;
}
