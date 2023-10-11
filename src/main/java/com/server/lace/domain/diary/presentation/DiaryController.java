package com.server.lace.domain.diary.presentation;

import com.server.lace.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.server.lace.domain.diary.service.CreateDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/diary")
public class DiaryController {

    private final CreateDiaryService createDiaryService;

    @PostMapping
    public ResponseEntity<Void> createDiary(@RequestBody @Valid CreateDiaryRequest createDiaryRequest) {
        createDiaryService.execute(createDiaryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
