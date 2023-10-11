package com.server.lace.domain.auth.exception;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicateIdException extends LaceException {

    public DuplicateIdException() {
        super(ErrorCode.DUPLICATE_ID);
    }

}
