package com.ahinski.hotels.validator.impl;

import com.ahinski.hotels.dto.ArrivalTimeDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.exception.ValidationException;
import com.ahinski.hotels.validator.DtoValidationStep;

public class ArrivalTimeValidationStep implements DtoValidationStep<HotelDto> {

    private DtoValidationStep<HotelDto> next;

    @Override
    public void validate(HotelDto dto) {
        ArrivalTimeDto arrivalTimeDto = dto.getArrivalTime();

        if (arrivalTimeDto.getCheckIn() == null) {
            throw new ValidationException("Check in must be provided");
        }

        if (next != null) {
            next.validate(dto);
        }
    }

    @Override
    public void setNext(DtoValidationStep<HotelDto> next) {
        this.next = next;
    }
}