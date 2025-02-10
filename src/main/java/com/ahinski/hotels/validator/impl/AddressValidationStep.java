package com.ahinski.hotels.validator.impl;

import com.ahinski.hotels.dto.AddressDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.exception.ValidationException;
import com.ahinski.hotels.validator.DtoValidationStep;

public class AddressValidationStep implements DtoValidationStep<HotelDto> {

    private DtoValidationStep<HotelDto> next;

    @Override
    public void validate(HotelDto dto) {
        AddressDto addressDto = dto.getAddress();

        if (addressDto.getHouseNumber() == null) {
            throw new ValidationException("House number must be provided");
        }

        if (addressDto.getStreet() == null) {
            throw new ValidationException("Street must be provided");
        }

        if (addressDto.getCity() == null) {
            throw new ValidationException("City must be provided");
        }

        if (addressDto.getCountry() == null) {
            throw new ValidationException("Country must be provided");
        }

        if (addressDto.getPostCode() == null) {
            throw new ValidationException("Post code must be provided");
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