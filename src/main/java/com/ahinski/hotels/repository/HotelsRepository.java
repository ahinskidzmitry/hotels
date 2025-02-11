package com.ahinski.hotels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahinski.hotels.model.Hotel;

/**
 * Amenities Repository for managing hotel models
 * 
 * @author Dzmitry Ahinski
 * 
 */
@Repository
public interface HotelsRepository extends JpaRepository<Hotel, Long> {

    @Query("""
            select h from Hotel h
            left join h.address adrs
            left join h.amenities amt
            where
            (:name is null or LOWER(h.name) = LOWER(:name))
            and (:brand is null or LOWER(h.brand) = LOWER(:brand))
            and (:city is null or LOWER(adrs.city) = LOWER(:city))
            and (:country is null or LOWER(adrs.country) = LOWER(:country))
            and (:amenities is null or LOWER(amt.name) in :amenities)
            """)
    List<Hotel> findAllByCriteria(String name, String brand, String city, String country, List<String> amenities);

    @Query("select brand, count(h) from Hotel h group by h.brand")
    List<Object[]> countByBrand();

    @Query("select addr.city, count(h) from Hotel h join h.address addr group by addr.city")
    List<Object[]> countByCity();

    @Query("select addr.country, count(h) from Hotel h join h.address addr group by addr.country")
    List<Object[]> countByCountry();

    @Query("select amnty.name, count(h) from Hotel h join h.amenities amnty group by amnty.name")
    List<Object[]> countByAmenities();
}