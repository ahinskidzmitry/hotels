package com.ahinski.hotels.service;

import java.util.List;
import java.util.Map;

import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;

public interface HotelsService {

    List<BriefHotelDto> findAll();

    HotelDto findById(Long id);

    List<BriefHotelDto> findAllByCriteria(String name, String brand, String city, String country, List<String> amenities);

    BriefHotelDto save(HotelDto hotelDto);

    HotelDto updateAmenities(Long id, List<String> amenities);

    Map<String, Long> countByParameters(String param);
}