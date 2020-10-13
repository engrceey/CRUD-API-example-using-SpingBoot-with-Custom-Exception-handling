package com.zurum.learningcrud.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6769829250639411880L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
