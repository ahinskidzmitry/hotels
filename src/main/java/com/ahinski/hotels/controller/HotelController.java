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

/**
 * 
 * REST Controller for managing hotels
 * 
 * @author Dzmitry Ahinski
 * 
 */
@RestController
@RequestMapping("/property-view")
public class HotelController {

    private final HotelsService hotelsService;

    public HotelController(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    /**
     * Retrieves all hotels
     * 
     * @return List of BriefHotelDtos with brief hotels information
     */
    @GetMapping("/hotels")
    public List<BriefHotelDto> findBriefHotels() {
        return hotelsService.findAll();
    }

    /**
     * Retrieves hotel by ID
     * 
     * @param id of the hotel to find
     * @return HotelDto with full hotel information
     */
    @GetMapping("/hotels/{id}")
    public HotelDto findHotelById(@PathVariable Long id) {
        return hotelsService.findById(id);
    }

    /**
     * Retrieves all hotels by search criteria
     * 
     * @param name as search criteria
     * @param brand as search criteria
     * @param city as search criteria
     * @param country as search criteria
     * @param amenities as search criteria
     * @return List of BriefHotelDtos with brief hotels information
     */
    @GetMapping("/search")
    public List<BriefHotelDto> findHotelsByCriteria(@RequestParam(required = false) String name, 
                                                    @RequestParam(required = false) String brand, 
                                                    @RequestParam(required = false) String city, 
                                                    @RequestParam(required = false) String country, 
                                                    @RequestParam(required = false) List<String> amenities) {
        return hotelsService.findAllByCriteria(name, brand, city, country, amenities);
    }
    
    /**
     * Creates new hotel
     * 
     * @param hotelDto to create
     * @return BriefHotelDto with created hotel brief information
     */
    @PostMapping("/hotels")
    public BriefHotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelsService.save(hotelDto);
    }

    /**
     * Adds new amenities to the hotel by ID
     * 
     * @param id of the hotel to add amenities
     * @param amenities to add
     * @return HotelDto with full updated hotel information
     */
    @PostMapping("/hotels/{id}/amenities")
    public HotelDto updateHotelAmenities(@PathVariable Long id, @RequestBody List<String> amenities) {
        return hotelsService.updateAmenities(id, amenities);
    }

    /**
     * Counts hotels by parameter
     * 
     * @param param to count
     * @return Map of params and amount
     */
    @GetMapping("/histogram/{param}")
    public Map<String, Long> countByParameter(@PathVariable String param) {
        return hotelsService.countByParameter(param);
    } 
}
