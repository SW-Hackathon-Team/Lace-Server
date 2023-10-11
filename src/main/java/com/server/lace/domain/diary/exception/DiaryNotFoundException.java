package com.server.lace.domain.diary.exception;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.enums.ErrorCode;

public class DiaryNotFoundException extends LaceException {

    public DiaryNotFoundException() {
        super(ErrorCode.DIARY_NOT_FOUND);
    }

}