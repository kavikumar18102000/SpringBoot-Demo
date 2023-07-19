package com.example.demo.ErrorException;

public class DepartmentNotFoundExcetion extends Exception{
    public DepartmentNotFoundExcetion() {
        super();
    }

    public DepartmentNotFoundExcetion(String message) {
        super(message);
    }

    public DepartmentNotFoundExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundExcetion(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
