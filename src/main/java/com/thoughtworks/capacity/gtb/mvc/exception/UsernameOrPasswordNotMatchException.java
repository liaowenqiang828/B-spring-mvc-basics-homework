package com.thoughtworks.capacity.gtb.mvc.exception;

public class UsernameOrPasswordNotMatchException extends RuntimeException {
    public UsernameOrPasswordNotMatchException(String message) {
        super(message);
    }
}
