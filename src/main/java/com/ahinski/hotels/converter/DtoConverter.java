package com.ahinski.hotels.converter;

public interface DtoConverter<E, D> extends EntityToDtoConverter<E, D> {
    
    E convertToEntity(D dto);
}