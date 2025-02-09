package com.ahinski.hotels.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.converter.EntityToDtoConverter;
import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.exception.HotelDoesNotExistException;
import com.ahinski.hotels.model.Amenity;
import com.ahinski.hotels.model.Hotel;
import com.ahinski.hotels.repository.AmenitiesRepository;
import com.ahinski.hotels.repository.HotelsRepository;
import com.ahinski.hotels.service.HotelsService;
import com.ahinski.hotels.validator.DtoValidationChain;

import jakarta.transaction.Transactional;

@Service
public class HotelsServiceImpl implements HotelsService {
    
    private final HotelsRepository hotelsRepository;
    private final AmenitiesRepository amenitiesRepository;
    private final DtoConverter<Hotel, HotelDto> hotelDtoConverter;
    private final EntityToDtoConverter<Hotel, BriefHotelDto> briefHotelToDtoConverter;
    private final DtoValidationChain dtoValidationChain;

    public HotelsServiceImpl(HotelsRepository hotelsRepository, AmenitiesRepository amenitiesRepository, DtoConverter<Hotel, HotelDto> hotelDtoConverter, 
                                EntityToDtoConverter<Hotel, BriefHotelDto> briefHotelToDtoConverter,  DtoValidationChain dtoValidationChain) {
        this.hotelsRepository = hotelsRepository;
        this.amenitiesRepository = amenitiesRepository;
        this.hotelDtoConverter = hotelDtoConverter;
        this.briefHotelToDtoConverter = briefHotelToDtoConverter;
        this.dtoValidationChain = dtoValidationChain;
    }

    @Override
    public List<BriefHotelDto> findAll() {
        return hotelsRepository.findAll()
                                .stream()
                                .map(hotel -> briefHotelToDtoConverter.convertToDto(hotel))
                                .toList();
    }

    @Override
    public HotelDto findById(Long id) {
        return hotelDtoConverter.convertToDto(
            hotelsRepository.findById(id).orElseThrow(
                () -> new HotelDoesNotExistException(String.format("Hotel with ID %d does not exist", id))
            )
        );
    }

    @Override
    public List<BriefHotelDto> findAllByCriteria(String name, String brand, String city, String country,
                                                 List<String> amenities) {
        
        return hotelsRepository.findAllByCriteria(name, brand, city, country, amenities)
                                .stream()
                                .map(briefHotelToDtoConverter::convertToDto)
                                .toList();
    }

    @Override
    public BriefHotelDto save(HotelDto hotelDto) {
        dtoValidationChain.validate(hotelDto);
        Hotel hotel = hotelDtoConverter.convertToEntity(hotelDto);
        BriefHotelDto briefHotelDto = briefHotelToDtoConverter.convertToDto(hotelsRepository.save(hotel));
        return briefHotelDto;
    }

    @Transactional
    @Override
    public HotelDto updateAmenities(Long id, List<String> amenities) {
        Hotel hotel = hotelsRepository.findById(id).orElseThrow(
            () -> new HotelDoesNotExistException(String.format("Hotel with ID %d does not exist", id))
        );
        
        List<Amenity> existingAmenities = amenitiesRepository.findByNameIn(amenities);
        Set<String> existingAmenitiesNames = existingAmenities.stream().map(Amenity::getName).collect(Collectors.toSet());
        amenities.removeIf(existingAmenitiesNames::contains);

        List<Amenity> amenitiesToCreate = amenities.stream().map(name -> new Amenity(name)).collect(Collectors.toList());
        List<Amenity> createdAmenities = amenitiesRepository.saveAll(amenitiesToCreate);

        existingAmenities.addAll(createdAmenities);

        hotel.setAmenities(existingAmenities);

        return hotelDtoConverter.convertToDto(hotelsRepository.save(hotel));
    }
 
    @Override
    public Map<String, Long> countByParameters(String param) {
        
        List<Object[]> groupsByBrandList = switch (param) {
            case "brand" -> hotelsRepository.countByBrand();
            case "city" -> hotelsRepository.countByCity();
            case "country" -> hotelsRepository.countByCountry();
            case "amenities" -> hotelsRepository.countByAmenities();
            default -> throw new IllegalArgumentException(String.format("Argument %s is not valid", param));
        };

        Map<String, Long> groupsByBrandMap = groupsByBrandList.stream().collect(Collectors.toMap(arr -> (String) arr[0], arr -> (Long) arr[1]));
        return groupsByBrandMap;
    }
}
