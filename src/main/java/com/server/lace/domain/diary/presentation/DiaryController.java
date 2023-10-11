package com.server.lace.domain.diary.presentation;

import com.server.lace.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.server.lace.domain.diary.presentation.dto.request.UpdateDiaryRequest;
import com.server.lace.domain.diary.presentation.dto.response.DiaryResponse;
import com.server.lace.domain.diary.service.CreateDiaryService;
import com.server.lace.domain.diary.service.GetDiaryService;
import com.server.lace.domain.diary.service.UpdateDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/diary")
public class DiaryController {

    private final CreateDiaryService createDiaryService;
    private final GetDiaryService getDiaryService;
    private final UpdateDiaryService updateDiaryService;

    @PostMapping
    public ResponseEntity<Void> createDiary(@RequestBody @Valid CreateDiaryRequest createDiaryRequest) {
        createDiaryService.execute(createDiaryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryResponse> readDiary(@PathVariable(name = "id") Long diaryId) {
        DiaryResponse diary = getDiaryService.execute(diaryId);
        return ResponseEntity.ok(diary);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateDiary(@PathVariable(name = "id") Long diaryId, @RequestBody @Valid UpdateDiaryRequest updateDiaryRequest) {
        updateDiaryService.execute(diaryId, updateDiaryRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
