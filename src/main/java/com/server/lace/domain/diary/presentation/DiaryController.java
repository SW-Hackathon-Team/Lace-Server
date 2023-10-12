package com.server.lace.domain.diary.presentation;

import com.server.lace.domain.diary.presentation.dto.request.CreateDiaryRequest;
import com.server.lace.domain.diary.presentation.dto.request.UpdateDiaryRequest;
import com.server.lace.domain.diary.presentation.dto.response.DiaryResponse;
import com.server.lace.domain.diary.service.CreateDiaryService;
import com.server.lace.domain.diary.service.DeleteDiaryService;
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
    private final DeleteDiaryService deleteDiaryService;

    @PostMapping
    public ResponseEntity<Void> createDiary(@RequestBody @Valid CreateDiaryRequest createDiaryRequest) {
        createDiaryService.execute(createDiaryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<DiaryResponse> readDiary() {
        DiaryResponse diary = getDiaryService.execute();
        return ResponseEntity.ok(diary);
    }

    @PatchMapping
    public ResponseEntity<Void> updateDiary(@RequestBody @Valid UpdateDiaryRequest updateDiaryRequest) {
        updateDiaryService.execute(updateDiaryRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable(name = "id") Long diaryId) {
        deleteDiaryService.execute(diaryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
