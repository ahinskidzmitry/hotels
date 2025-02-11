package com.ahinski.hotels.service;

import java.util.List;
import java.util.Map;

import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.HotelDto;

/**
 * Hotels Service for managing hotels
 * 
 * @author Dzmitry Ahinski
 * 
 */
public interface HotelsService {

    /**
     * Retrieves all hotels
     * 
     * @return List of BriefHotelDtos with brief hotels information
     */
    List<BriefHotelDto> findAll();

    /**
     * Retrieves hotel by ID
     * 
     * @param id of the hotel to find
     * @return HotelDto with full hotel information
     */
    HotelDto findById(Long id);

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
    List<BriefHotelDto> findAllByCriteria(String name, String brand, String city, String country, List<String> amenities);

    /**
     * Creates new hotel
     * 
     * @param hotelDto to create
     * @return BriefHotelDto with created hotel brief information
     */
    BriefHotelDto save(HotelDto hotelDto);

    /**
     * Adds new amenities to the hotel by ID
     * 
     * @param id of the hotel to add amenities
     * @param amenities to add
     * @return HotelDto with full updated hotel information
     */
    HotelDto updateAmenities(Long id, List<String> amenities);

    /**
     * Counts hotels by parameter
     * 
     * @param param to count
     * @return Map of params and amount
     */
    Map<String, Long> countByParameter(String param);
}