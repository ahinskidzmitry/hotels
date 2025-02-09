package com.ahinski.hotels.validator;

import org.springframework.stereotype.Component;

import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.validator.impl.AddressValidationStep;
import com.ahinski.hotels.validator.impl.ArrivalTimeValidationStep;
import com.ahinski.hotels.validator.impl.ContactsValidationStep;
import com.ahinski.hotels.validator.impl.HotelValidationStep;

@Component
public class DtoValidationChain {

    private DtoValidationStep<HotelDto> head;

    public DtoValidationChain() {
        HotelValidationStep hotelValidationStep = new HotelValidationStep();
        AddressValidationStep addressValidationStep = new AddressValidationStep();
        ContactsValidationStep contactsValidationStep = new ContactsValidationStep();
        ArrivalTimeValidationStep arrivalTimeValidationStep = new ArrivalTimeValidationStep();

        hotelValidationStep.setNext(addressValidationStep);
        addressValidationStep.setNext(contactsValidationStep);
        contactsValidationStep.setNext(arrivalTimeValidationStep);

        head = hotelValidationStep;
    }

    public void validate(HotelDto hotelDto) {
        head.validate(hotelDto);
    }
}
