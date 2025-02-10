package com.ahinski.hotels.converter.impl;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.dto.ArrivalTimeDto;
import com.ahinski.hotels.model.ArrivalTime;


class ArrivalTimeDtoConverter implements DtoConverter<ArrivalTime, ArrivalTimeDto> {

    @Override
    public ArrivalTimeDto convertToDto(ArrivalTime entity) {
        ArrivalTimeDto arrivalTimeDto = new ArrivalTimeDto();

        arrivalTimeDto.setCheckIn(entity.getCheckIn());
        arrivalTimeDto.setCheckOut(entity.getCheckOut());

        return arrivalTimeDto;
    }

    @Override
    public ArrivalTime convertToEntity(ArrivalTimeDto dto) {
        ArrivalTime arrivalTime = new ArrivalTime();

        arrivalTime.setCheckIn(dto.getCheckIn());
        arrivalTime.setCheckOut(dto.getCheckOut());

        return arrivalTime;
    }
}