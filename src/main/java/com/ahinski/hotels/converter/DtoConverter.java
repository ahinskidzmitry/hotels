package com.ahinski.hotels.converter;


/**
 * DTO to entity and back conversion interface
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface DtoConverter<E, D> extends EntityToDtoConverter<E, D> {
    
    E convertToEntity(D dto);
}