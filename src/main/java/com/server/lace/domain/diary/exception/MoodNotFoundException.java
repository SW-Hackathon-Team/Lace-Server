package com.server.lace.domain.diary.exception;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.enums.ErrorCode;

public class MoodNotFoundException extends LaceException {

    public MoodNotFoundException() {
        super(ErrorCode.MOOD_NOT_FOUND);
    }

}
