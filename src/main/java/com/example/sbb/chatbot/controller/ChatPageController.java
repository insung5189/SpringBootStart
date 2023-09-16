package com.example.sbb.chatbot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatPageController {

    @GetMapping("/page")
    public String chatPage() {
        return "chat_page";
    }
}