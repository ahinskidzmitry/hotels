package com.ahinski.hotels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.service.HotelsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/property-view")
public class HotelController {

    private final HotelsService hotelsService;

    public HotelController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }
    
    @PostMapping("/hotels")
    public BriefHotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelsService.save(hotelDto);
    }
}
