package com.server.lace.domain.diary.presentation.dto.request;

import com.server.lace.domain.diary.entity.enums.Mood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiaryRequest {

    @NotBlank(message = "제목이 입력되지 않았습니다.")
    private String title;

    @NotBlank(message = "내용이 입력되지 않았습니다.")
    private String content;

    @NotBlank(message = "기분이 입력되지 않았습니다.")
    private String mood;

}
