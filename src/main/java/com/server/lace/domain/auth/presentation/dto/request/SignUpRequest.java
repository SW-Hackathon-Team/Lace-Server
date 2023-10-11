package com.server.lace.domain.auth.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "아이디가 입력되지 않았습니다.")
    private String loginId;

    @NotBlank(message = "비밀번호가 입력되지 않았습니다.")
    private String password;

    @NotBlank(message = "이름이 입력되지 않았습니다.")
    private String name;

    @NotNull(message = "나이가 입력되지 않았습니다.")
    private Integer age;

}