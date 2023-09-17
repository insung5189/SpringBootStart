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
            "환영합니다! 저는 인성님을 돕는 다빈치에요 즐거운 대화를 시작해봐요.😁",
            "반갑습니다! 저는 인성님을 돕는 다빈치에요 어떤 도움이 필요하신가요?😁",
            "안녕하세요! 저는 인성님을 돕는 다빈치에요 대화를 시작해보세요.😁",
            "환영합니다! 저는 인성님을 돕는 다빈치에요 여기에서 궁금한 것을 물어보세요.😁",
            "나는야 야생의 다빈치! 결투를 시작하지! \uD83E\uDD3A",
            "ㅎㅇ~😉",
            "얼굴 보니 좋으네용 ㅎㅎ😀",
            "어서와! ㅎㅎ😀",
            "반갑습니다!😉",
            "만나서 반갑습니다!🧔🏻",
            "안뇽!🖐🏻🖐🏻🖐🏻",
            "안녕하세요! 오늘은 뭘 드셨나요?🥩",
            "안녕하세요! 잠은 잘 주무셨나요?🛌🏻",
            "안녕하세요! 아픈 덴 없으시죠?💊",
            "잠깐만! 올 때 메로나 사왔어?🍦",
            "내일 저랑 영화보러 가실래요?📽️",
            "아.. 나 오늘도 운동 못 갔어...🏀",
            "안녕! 밥은 먹었어?🍚",
            "안녕! 밥은 먹었어?🍙",
            "나 놀아주러 온거야?🎡",
            "오늘은 뭐 하고 놀까?🎠",
            "오셨군요! \uD83D\uDE04",
            "안녕하세요! 피자는 가져오셨겠죠? 🍕",
            "오늘은 햄버거 어때? 🍔",
            "비올 땐 쏘주에 킹치찌개🍲",
            "아름다운 날이에요 그쵸?🌤️",
            "기분이 더 좋아지실 거에요🧙🏻️",
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
