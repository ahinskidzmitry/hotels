package com.ahinski.hotels.converter.impl;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.dto.AddressDto;
import com.ahinski.hotels.model.Address;

class AddressDtoConverter implements DtoConverter<Address, AddressDto> {

    @Override
    public AddressDto convertToDto(Address entity) {
        AddressDto addressDto = new AddressDto();
        
        addressDto.setHouseNumber(entity.getHouseNumber());
        addressDto.setStreet(entity.getStreet());
        addressDto.setCity(entity.getCity());
        addressDto.setCountry(entity.getCountry());
        addressDto.setPostCode(entity.getPostCode());

        return addressDto;
    }

    @Override
    public Address convertToEntity(AddressDto dto) {
        Address address = new Address();

        address.setHouseNumber(dto.getHouseNumber());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCountry(dto.getCountry());
        address.setPostCode(dto.getPostCode());

        return address;
    }
}
