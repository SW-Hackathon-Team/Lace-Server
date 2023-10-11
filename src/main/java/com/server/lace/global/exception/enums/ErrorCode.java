package com.server.lace.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // TOKEN
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),
    REFRESH_TOKEN_NOT_FOUND("존재하지 않는 리프레시 토큰입니다.", 404),
    EXPIRED_TOKEN("토큰이 만료되었습니다.", 419),

    // AUTH
    DUPLICATE_ID("이미 존재하는 id 입니다.", 400),
    MIS_MATCH_PASSWORD("비밀번호가 일치하지 않습니다.", 400),

    // MEMBER
    MEMBER_NOT_FOUND("사용자를 찾을 수 없습니다.", 404);

    private final String message;
    private final int status;

}

