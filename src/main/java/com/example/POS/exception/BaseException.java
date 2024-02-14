package com.example.POS.exception;

public class BaseException extends Exception{
    public BaseException(String message){
        super(message);
    }

    public static String ProductNameNull(){
        return "Product name cannot be null";
    }

    public static String ProductAlreadyExists(){
        return "Product already exists";
    }
}
