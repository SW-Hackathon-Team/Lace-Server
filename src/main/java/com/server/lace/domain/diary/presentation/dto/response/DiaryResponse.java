package com.server.lace.domain.diary.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryResponse {

    private String title;

    private String content;

    private String mood;

    private LocalDateTime createdAt;

}