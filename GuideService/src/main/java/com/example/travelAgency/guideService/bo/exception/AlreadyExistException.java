package com.example.travelAgency.guideService.bo.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message){
        super(message);
    }
}
