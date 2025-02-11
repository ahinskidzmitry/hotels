package com.ahinski.hotels.exception;


public class HotelDoesNotExistException extends RuntimeException {
    
    public HotelDoesNotExistException(String message) {
        super(message);
    }
}