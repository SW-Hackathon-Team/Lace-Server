package com.server.lace.global.security.exception;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class TokenNotValidException extends LaceException {

    public TokenNotValidException() {
        super(ErrorCode.TOKEN_NOT_VALID);
    }

}
