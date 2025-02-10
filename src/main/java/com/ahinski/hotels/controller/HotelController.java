package com.ahinski.hotels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.service.HotelsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/search")
    public List<BriefHotelDto> findHotelsByCriteria(@RequestParam(required = false) String name, 
                                                    @RequestParam(required = false) String brand, 
                                                    @RequestParam(required = false) String city, 
                                                    @RequestParam(required = false) String country, 
                                                    @RequestParam(required = false) List<String> amenities) {
        return hotelsService.findAllByCriteria(name, brand, city, country, amenities);
    }
    
    @PostMapping("/hotels")
    public BriefHotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelsService.save(hotelDto);
    }

    @PostMapping("/hotels/{id}/amenities")
    public HotelDto updateHotelAmenities(@PathVariable Long id, @RequestBody List<String> amenities) {
        return hotelsService.updateAmenities(id, amenities);
    }

    @GetMapping("/histogram/{param}")
    public Map<String, Long> countByParameter(@PathVariable String param) {
        return hotelsService.countByParameter(param);
    } 
}
