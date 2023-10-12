package com.server.lace.domain.chatgpt.presentation;


import com.server.lace.domain.chatgpt.presentation.dto.request.QuestionRequest;
import com.server.lace.domain.chatgpt.presentation.dto.response.ChatGptResponse;
import com.server.lace.domain.chatgpt.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RequiredArgsConstructor
@RequestMapping("/api/v1/gpt")
@RestController
public class ChatGptController {
    private final ChatGptService chatGptService;

    @PostMapping("/solution")
    public ChatGptResponse sendQuestion(
            Locale locale,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody QuestionRequest questionRequest) {
        ChatGptResponse chatGptResponse = null;
        try {
            chatGptResponse = chatGptService.askQuestion(questionRequest);
        } catch (Exception e) {

        }
        return chatGptResponse;
    }
}
