package com.ahinski.hotels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahinski.hotels.model.Amenity;

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenity, Long> {
    
    List<Amenity> findByNameIn(List<String> names);
}