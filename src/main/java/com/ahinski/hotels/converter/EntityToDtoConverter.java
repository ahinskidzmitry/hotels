package com.ahinski.hotels.converter;


public interface EntityToDtoConverter<E, D> {
    
    D convertToDto(E entity);
}