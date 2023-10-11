package com.server.lace.global.security.exception;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class TokenExpirationException extends LaceException {

    public TokenExpirationException() {
        super(ErrorCode.TOKEN_EXPIRATION);
    }

}
