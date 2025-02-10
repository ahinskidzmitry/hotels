package com.ahinski.hotels.converter.impl;

import org.springframework.stereotype.Component;

import com.ahinski.hotels.converter.EntityToDtoConverter;
import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.model.Address;
import com.ahinski.hotels.model.Hotel;


@Component
public class BriefHotelToDtoConverter implements EntityToDtoConverter<Hotel, BriefHotelDto> {

    private static final String WHITESPACE = " ";
    private static final String WHITESPACE_WITH_COMMA = ", ";

    @Override
    public BriefHotelDto convertToDto(Hotel entity) {
        BriefHotelDto briefHotelDto = new BriefHotelDto();

        briefHotelDto.setId(entity.getId());
        briefHotelDto.setName(entity.getName());
        briefHotelDto.setDescription(entity.getDescription());
        briefHotelDto.setAddress(prepareBriefAddress(entity.getAddress()));
        briefHotelDto.setPhone(entity.getContacts().getPhone());

        return briefHotelDto;
    }

    private String prepareBriefAddress(Address address) {
        StringBuilder addressBuilder = new StringBuilder();

        addressBuilder.append(address.getHouseNumber());
        addressBuilder.append(WHITESPACE);
        addressBuilder.append(address.getStreet());
        addressBuilder.append(WHITESPACE_WITH_COMMA);
        addressBuilder.append(address.getCity());
        addressBuilder.append(WHITESPACE_WITH_COMMA);
        addressBuilder.append(address.getPostCode());
        addressBuilder.append(WHITESPACE_WITH_COMMA);
        addressBuilder.append(address.getCountry());

        return addressBuilder.toString();
    }
}