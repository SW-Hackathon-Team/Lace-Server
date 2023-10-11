package com.server.lace.domain.member.exception;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class MemberNotFoundException extends LaceException {

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }

}
