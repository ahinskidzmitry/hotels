package com.ahinski.hotels.validator.impl;

import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.exception.ValidationException;
import com.ahinski.hotels.validator.DtoValidationStep;

public class HotelValidationStep implements DtoValidationStep<HotelDto> {

    private DtoValidationStep<HotelDto> next;

    @Override
    public void validate(HotelDto dto) {
        if (dto == null) {
            throw new ValidationException("Hotel must be provided");
        }

        if (dto.getName() == null) {
            throw new ValidationException("Name must be provided");
        }

        if (dto.getBrand() == null) {
            throw new ValidationException("Brand must be provided");
        }

        if (dto.getAddress() == null) {
            throw new ValidationException("Adress must be provided");
        }

        if (dto.getContacts() == null) {
            throw new ValidationException("Contacts must be provided");
        }

        if (dto.getArrivalTime() == null) {
            throw new ValidationException("Arrival time must be provided");
        }

        next.validate(dto);
    }

    @Override
    public void setNext(DtoValidationStep<HotelDto> next) {
        this.next = next;
    }
}
