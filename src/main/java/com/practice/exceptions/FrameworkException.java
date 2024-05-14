package com.practice.exceptions;

public class FrameworkException extends RuntimeException{

    public FrameworkException(String message){
        super(message);
    }
    public FrameworkException(String message,Throwable e){
        super(message,e);
    }

}
