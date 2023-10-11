package com.server.lace.domain.auth.exception;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class MisMatchPasswordException extends LaceException {

    public MisMatchPasswordException() {
        super(ErrorCode.MIS_MATCH_PASSWORD);
    }

}