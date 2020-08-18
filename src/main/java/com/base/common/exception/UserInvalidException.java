package com.base.common.exception;

public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, 400);
    }
}
