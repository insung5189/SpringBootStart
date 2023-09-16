package com.example.sbb.chatbot.controller;

import com.example.sbb.chatbot.domain.WelcomeMessage;
import com.example.sbb.chatbot.service.OpenAIChatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final OpenAIChatClient openAIChatClient;

    private static final List<String> welcomeMessages = Arrays.asList(
            "환영합니다! 저는 인성님을 돕는 다빈치에요 즐거운 대화를 시작해봐요.",
            "반갑습니다! 저는 인성님을 돕는 다빈치에요 어떤 도움이 필요하신가요?",
            "안녕하세요! 저는 인성님을 돕는 다빈치에요 대화를 시작해보세요.",
            "환영합니다! 저는 인성님을 돕는 다빈치에요 여기에서 궁금한 것을 물어보세요.",
            "안녕하세요! 저는 인성님을 돕는 다빈치에요 대화를 통해 도움을 드릴게요."
    );

    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendChatMessage(@RequestBody String message) {
        String response = openAIChatClient.sendMessage(message);
        return "{\"message\":\"" + response + "\"}";
    }

    @GetMapping("/welcome")
    public WelcomeMessage getWelcomeMessage() {
        String randomMessage = getRandomWelcomeMessage();
        return new WelcomeMessage(randomMessage);
    }

    private String getRandomWelcomeMessage() {
        Random random = new Random();
        int randomIndex = random.nextInt(welcomeMessages.size());
        return welcomeMessages.get(randomIndex);
    }
}
