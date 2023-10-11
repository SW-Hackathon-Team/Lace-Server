package com.server.lace.global.exception;

import com.server.lace.global.exception.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LaceException extends RuntimeException {

    final ErrorCode errorCode;

}
