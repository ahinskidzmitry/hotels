package com.ahinski.hotels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahinski.hotels.model.Hotel;

@Repository
public interface HotelsRepository extends JpaRepository<Hotel, Long> {

    @Query("""
            select h from Hotel h
            left join h.amenities amt
            left join h.address adrs
            where
            (:name is null or h.name = :name)
            and (:brand is null or h.brand = :brand)
            and (:city is null or adrs.city = :city)
            and (:country is null or adrs.country = :country)
            and (:amenities is null or amt.name in :amenities)
            """)
    List<Hotel> findAllByCriteria(String name, String brand, String city, String country, List<String> amenities);

    @Query("select brand, count(h) from Hotel h group by h.brand")
    List<Object[]> countByBrand();

    @Query("select addr.city, count(h) from Hotel h join addresses addr group by addr.city")
    List<Object[]> countByCity();

    @Query("select addr.country, count(h) from Hotel h join addresses addr group by addr.country")
    List<Object[]> countByCountry();

    @Query("select amnty.name, count(h) from Hotel h join amenities amnty group by amnty.name")
    List<Object[]> countByAmenities();
}