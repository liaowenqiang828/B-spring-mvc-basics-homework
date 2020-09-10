package com.thoughtworks.capacity.gtb.mvc.domain;


public class Constants {
    public static final String USERNAME_LENGTH_ERROR = "username length must between 3 and 12";
    public static final String USERNAME_CONTENT_ERROR = "username should only contain number or letter or underline";
    public static final String USERNAME_UNIQUE_ERROR = "username should be unique";
    public static final String USERNAME_EMPTY_ERROR = "username can not be empty";
    public static final int USERNAME_MIN_LENGTH = 3;
    public static final int USERNAME_MAX_LENGTH = 10;

    public static final String PASSWORD_EMPTY_ERROR = "password can not be empty";
    public static final String PASSWORD_LENGTH_ERROR = "password length must between 5 and 12";
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 12;

    public static final String EMAIL_CONTENT_ERROR = "email must has right format";
    public static final String LOGIN_FAILED_ERROR = "username or password not matched";
}
