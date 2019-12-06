package com.edu.school.courses.exception;

public class GroupExistsException extends SubExpections {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    GroupExistsException(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
