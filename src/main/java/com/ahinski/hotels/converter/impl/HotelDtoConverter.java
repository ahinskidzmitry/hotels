package com.ahinski.hotels.converter.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.dto.AddressDto;
import com.ahinski.hotels.dto.AmenityDto;
import com.ahinski.hotels.dto.ArrivalTimeDto;
import com.ahinski.hotels.dto.ContactsDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.model.Address;
import com.ahinski.hotels.model.Amenity;
import com.ahinski.hotels.model.ArrivalTime;
import com.ahinski.hotels.model.Contacts;
import com.ahinski.hotels.model.Hotel;

@Component
public class HotelDtoConverter implements DtoConverter<Hotel, HotelDto> {

    private final AddressDtoConverter addressDtoConverter = new AddressDtoConverter();
    private final ContactsDtoConverter contactsDtoConverter = new ContactsDtoConverter();
    private final ArrivalTimeDtoConverter arrivalTimeDtoConverter = new ArrivalTimeDtoConverter();
    private final AmenityDtoConverter amenityDtoConverter = new AmenityDtoConverter();

    @Override
    public HotelDto convertToDto(Hotel entity) {
        HotelDto hotelDto = new HotelDto();

        hotelDto.setId(entity.getId());
        hotelDto.setName(entity.getName());
        hotelDto.setBrand(entity.getBrand());
        
        AddressDto addressDto = addressDtoConverter.convertToDto(entity.getAddress());
        hotelDto.setAddress(addressDto);

        ContactsDto contactsDto = contactsDtoConverter.convertToDto(entity.getContacts());
        hotelDto.setContacts(contactsDto);

        ArrivalTimeDto arrivalTimeDto = arrivalTimeDtoConverter.convertToDto(entity.getArrivalTime());
        hotelDto.setArrivalTime(arrivalTimeDto);

        List<AmenityDto> amenityDtos = entity.getAmenities()
                                            .stream()
                                            .map(amenity -> amenityDtoConverter.convertToDto(amenity))
                                            .toList();
        hotelDto.setAmenities(amenityDtos);

        return hotelDto;
    } 

    @Override
    public Hotel convertToEntity(HotelDto dto) {
        Hotel hotel = new Hotel();

        hotel.setId(dto.getId());
        hotel.setName(dto.getName());
        hotel.setDescription(dto.getDescription());
        hotel.setBrand(dto.getBrand());

        Address address = addressDtoConverter.convertToEntity(dto.getAddress());
        hotel.setAddress(address);

        Contacts contacts = contactsDtoConverter.convertToEntity(dto.getContacts());
        hotel.setContacts(contacts);

        ArrivalTime arrivalTime = arrivalTimeDtoConverter.convertToEntity(dto.getArrivalTime());
        hotel.setArrivalTime(arrivalTime);

        List<Amenity> amenities = dto.getAmenities()
                                    .stream()
                                    .map(amenityDto -> amenityDtoConverter.convertToEntity(amenityDto))
                                    .toList();
        hotel.setAmenities(amenities);

        return hotel;
    }
}
