package com.example.sbb.chatbot.logs;

import com.example.sbb.chatbot.logs.ChatLog;
import com.example.sbb.chatbot.logs.ChatLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatLogService {

    private final ChatLogRepository chatLogRepository;

    public List<ChatLog> getChatLogs() {
        // ChatLog 엔티티에 저장된 채팅 로그 목록을 가져오는 로직을 작성
        return chatLogRepository.findAll();
    }

    public ChatLog saveChatLog(String userMessage, String botResponse) {
        ChatLog chatLog = new ChatLog();
        chatLog.setUserMessage(userMessage);
        chatLog.setBotResponse(botResponse);
        chatLog.setTimestamp(LocalDateTime.now());
        return chatLogRepository.save(chatLog);
    }

    // 필요한 추가 메서드를 정의할 수 있습니다.
}
