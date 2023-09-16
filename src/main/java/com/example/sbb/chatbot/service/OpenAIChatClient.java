package com.example.sbb.chatbot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OpenAIChatClient {

    @Value("${openai.apiKey}")
    private String apiKey;
    @Value("${openai.endpoint}")
    private String endpoint;

    private final RestTemplate restTemplate;

    public String sendMessage(String message) {
        try {
            // 요청 본문을 구성합니다.
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "text-davinci-003");
            requestBody.put("prompt", message); // 사용자의 메시지를 프롬프트로 사용
            requestBody.put("max_tokens", 4000);
            requestBody.put("temperature", 0.8); // 0.0으로 설정하여 출력을 결정적으로 만듭니다.

            // 헤더를 설정합니다.
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey);
            headers.set("Content-Type", "application/json");

            // HTTP 요청 엔티티를 생성합니다.
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

            // OpenAI API로 POST 요청을 보냅니다.
            ResponseEntity<String> response = restTemplate.exchange(
                    endpoint, HttpMethod.POST, requestEntity, String.class);

            // 응답을 처리합니다.
            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();
                System.out.println("OpenAI Response: " + responseBody); // 로깅 또는 디버깅 목적으로 출력
                return parseResponse(responseBody);
            } else {
                System.err.println("OpenAI Error: " + response.getStatusCodeValue() + " - " + response.getBody());
                return "오류가 발생했습니다.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "오류가 발생했습니다.";
        }
    }

    // OpenAI 응답 텍스트에서 개행 문자를 제거하는 메서드
    private String removeNewlines(String text) {
        return text.replaceAll("\\n\\n", ""); // 개행 문자 두 개를 빈 문자열로 대체
    }


    private String parseResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            if (jsonNode.has("choices")) {
                JsonNode choices = jsonNode.get("choices");
                if (choices.isArray() && choices.size() > 0) {
                    JsonNode choice = choices.get(0);
                    if (choice.has("text")) {
                        String botResponse = choice.get("text").asText();
                        return removeNewlines(botResponse); // 개행 문자 제거
                    }
                }
            }
            return "No response from the bot.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error parsing bot response.";
        }
    }
}
