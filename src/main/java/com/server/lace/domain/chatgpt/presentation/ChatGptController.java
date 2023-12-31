package com.server.lace.domain.chatgpt.presentation;


import com.server.lace.domain.chatgpt.presentation.dto.request.QuestionRequest;
import com.server.lace.domain.chatgpt.presentation.dto.response.ChatGptResponse;
import com.server.lace.domain.chatgpt.service.ChatGptService;
import com.server.lace.domain.diary.presentation.dto.response.DiaryResponse;
import com.server.lace.domain.diary.service.GetDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RequiredArgsConstructor
@RequestMapping("/api/v1/gpt")
@RestController
public class ChatGptController {
    private final ChatGptService chatGptService;
    private final GetDiaryService getDiaryService;

    @PostMapping("/solution")
    public String sendQuestion(@RequestBody QuestionRequest questionRequest) {
        ChatGptResponse chatGptResponse = null;
        try {
            chatGptResponse = chatGptService.askQuestion(questionRequest);
        } catch (Exception e) {

        }
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/analyze")
    public String analyzeDiary() {
        DiaryResponse diaryResponse = getDiaryService.execute();
        return chatGptService.diaryAnalyze(diaryResponse).getChoices().get(0).getMessage().getContent();
    }

}
