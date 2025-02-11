package com.ahinski.hotels.converter;

/**
 * Entity to DTO conversion interface
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface EntityToDtoConverter<E, D> {
    
    D convertToDto(E entity);
}