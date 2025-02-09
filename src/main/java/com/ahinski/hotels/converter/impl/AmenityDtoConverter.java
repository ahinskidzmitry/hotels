package com.ahinski.hotels.converter.impl;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.dto.AmenityDto;
import com.ahinski.hotels.model.Amenity;

class AmenityDtoConverter implements DtoConverter<Amenity, AmenityDto> {

    @Override
    public AmenityDto convertToDto(Amenity entity) {
        AmenityDto amenityDto = new AmenityDto();

        amenityDto.setName(entity.getName());

        return amenityDto;
    }

    @Override
    public Amenity convertToEntity(AmenityDto dto) {
        Amenity amenity = new Amenity();

        amenity.setName(dto.getName());

        return amenity;
    }
}
