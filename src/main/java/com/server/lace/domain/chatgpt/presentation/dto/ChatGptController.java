package com.server.lace.domain.chatgpt.presentation.dto;


import com.server.lace.domain.chatgpt.presentation.dto.request.QuestionRequest;
import com.server.lace.domain.chatgpt.presentation.dto.response.ChatGptResponse;
import com.server.lace.domain.chatgpt.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RequiredArgsConstructor
@RequestMapping
@RestController("/api/v1/gpt/")
public class ChatGptController{
    private  final ChatGptService chatGptService;

    @PostMapping("/solution")
    public ChatGptResponse sendQuestion(
            Locale locale,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody QuestionRequest questionRequest){
        //String code = "success";
        ChatGptResponse chatGptResponse = null;
        try{
            chatGptResponse = chatGptService.askQuestion(questionRequest);

        }catch(Exception e){
            //code = e.getMessage();
        }
        return chatGptResponse;
    }
}
