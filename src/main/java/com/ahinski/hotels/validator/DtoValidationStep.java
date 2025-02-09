package com.ahinski.hotels.validator;

public interface DtoValidationStep<T> {
    
    void validate(T dto);

    void setNext(DtoValidationStep<T> next);
}
