package com.ahinski.hotels.service;

import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;

public interface HotelsService {

    BriefHotelDto save(HotelDto hotelDto);
}
