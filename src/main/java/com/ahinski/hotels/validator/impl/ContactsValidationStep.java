package com.ahinski.hotels.validator.impl;

import com.ahinski.hotels.dto.ContactsDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.exception.ValidationException;
import com.ahinski.hotels.validator.DtoValidationStep;

public class ContactsValidationStep implements DtoValidationStep<HotelDto> {

    private DtoValidationStep<HotelDto> next;

    @Override
    public void validate(HotelDto dto) {
        ContactsDto contactsDto = dto.getContacts();

        if (contactsDto.getEmail() == null) {
            throw new ValidationException("Email must be provided");
        }

        if (contactsDto.getPhone() == null) {
            throw new ValidationException("Phone number must be provided");
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