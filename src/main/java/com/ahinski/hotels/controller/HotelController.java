package com.ahinski.hotels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.service.HotelsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/property-view")
public class HotelController {

    private final HotelsService hotelsService;

    public HotelController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @GetMapping("/hotels")
    public List<BriefHotelDto> findBriefHotels() {
        return hotelsService.findAll();
    }

    @GetMapping("/hotels/{id}")
    public HotelDto findHotelById(@PathVariable Long id) {
        return hotelsService.findById(id);
    }
    
    @PostMapping("/hotels")
    public BriefHotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelsService.save(hotelDto);
    }

    @PostMapping("/hotels/{id}/amenities")
    public HotelDto updateHotelAmenities(@PathVariable Long id, @RequestBody List<String> amenities) {
        return hotelsService.updateAmenities(id, amenities);
    }
}
