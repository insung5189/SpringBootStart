package com.example.sbb.chatbot.controller;

import com.example.sbb.chatbot.service.OpenAIChatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final OpenAIChatClient openAIChatClient;
    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendChatMessage(@RequestBody String message) {
        String response = openAIChatClient.sendMessage(message);
        return "{\"message\":\"" + response + "\"}";
    }
}
