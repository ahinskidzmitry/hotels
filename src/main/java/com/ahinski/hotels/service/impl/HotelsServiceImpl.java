package com.ahinski.hotels.service.impl;

import org.springframework.stereotype.Service;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.converter.EntityToDtoConverter;
import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.model.Hotel;
import com.ahinski.hotels.repository.HotelsRepository;
import com.ahinski.hotels.service.HotelsService;
import com.ahinski.hotels.validator.DtoValidationChain;

@Service
public class HotelsServiceImpl implements HotelsService {
    
    private final HotelsRepository hotelsRepository;
    private final DtoConverter<Hotel, HotelDto> hotelDtoConverter;
    private final EntityToDtoConverter<Hotel, BriefHotelDto> briefHotelToDtoConverter;
    private final DtoValidationChain dtoValidationChain;

    public HotelsServiceImpl(HotelsRepository hotelsRepository, DtoConverter<Hotel, HotelDto> hotelDtoConverter, 
                                EntityToDtoConverter<Hotel, BriefHotelDto> briefHotelToDtoConverter, DtoValidationChain dtoValidationChain) {
        this.hotelsRepository = hotelsRepository;
        this.hotelDtoConverter = hotelDtoConverter;
        this.briefHotelToDtoConverter = briefHotelToDtoConverter;
        this.dtoValidationChain = dtoValidationChain;
    }

    @Override
    public BriefHotelDto save(HotelDto hotelDto) {
        dtoValidationChain.validate(hotelDto);
        Hotel hotel = hotelDtoConverter.convertToEntity(hotelDto);
        BriefHotelDto briefHotelDto = briefHotelToDtoConverter.convertToDto(hotelsRepository.save(hotel));
        return briefHotelDto;
    }
}
