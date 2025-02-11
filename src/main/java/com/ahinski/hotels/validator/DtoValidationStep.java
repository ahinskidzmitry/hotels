package com.ahinski.hotels.validator;

/**
 * Validation step used in validation chain to validate fields
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface DtoValidationStep<T> {
    
    /**
     * Validates DTO
     * 
     * @param dto to validate
     */
    void validate(T dto);

    /**
     * Sets reference to the next validation step
     * 
     * @param next validation step
     */
    void setNext(DtoValidationStep<T> next);
}