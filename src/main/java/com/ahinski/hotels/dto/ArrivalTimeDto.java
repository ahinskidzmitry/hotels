package com.ahinski.hotels.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Arrival Time data transfer object
 * 
 * @author Dzmitry Ahinski
 * 
 */
public class ArrivalTimeDto {
    
    private LocalTime checkIn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalTime checkOut;

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
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
        ArrivalTimeDto other = (ArrivalTimeDto) obj;
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
        return "ArrivalTimeDto [checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
    }
}