package com.practice.exceptions;

public class InvalidPathForExcelException extends FrameworkException{

    public InvalidPathForExcelException(String message){
        super(message);
    }
    public InvalidPathForExcelException(String message,Throwable e){
        super(message,e);
    }
}
