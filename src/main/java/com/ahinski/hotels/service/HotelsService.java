package com.ahinski.hotels.service;

import java.util.List;

import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;

public interface HotelsService {

    List<BriefHotelDto> findAll();

    BriefHotelDto save(HotelDto hotelDto);
}
