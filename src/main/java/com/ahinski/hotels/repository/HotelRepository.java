package com.ahinski.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahinski.hotels.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {}
