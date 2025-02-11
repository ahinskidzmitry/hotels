package com.ahinski.hotels.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Arrival Time model
 * 
 * @author Dzmitry Ahinski
 * 
 */
@Entity
@Table(name = "arrival_time")
public class ArrivalTime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARRIVAL_TIME_SEQ")
    @SequenceGenerator(name = "ARRIVAL_TIME_SEQ", sequenceName = "ARRIVAL_TIME_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "check_in")
    private LocalTime checkIn;

    @Column(name = "check_out")
    private LocalTime checkOut;

    public Long getId() {
        return id;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
        result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArrivalTime other = (ArrivalTime) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (checkIn == null) {
            if (other.checkIn != null)
                return false;
        } else if (!checkIn.equals(other.checkIn))
            return false;
        if (checkOut == null) {
            if (other.checkOut != null)
                return false;
        } else if (!checkOut.equals(other.checkOut))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArrivalTime [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
    }
}