package com.lvcom.practice_app.exception;

public class IllegalEntityException extends ApplicationException {
    public IllegalEntityException() {
    }

    public IllegalEntityException(String message) {
        super(message);
    }

    public IllegalEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
