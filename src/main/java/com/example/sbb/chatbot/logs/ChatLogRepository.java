package com.example.sbb.chatbot.logs;

import com.example.sbb.chatbot.logs.ChatLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLogRepository extends JpaRepository<ChatLog, Long> {
    // 추가적인 쿼리 메서드들...
}
