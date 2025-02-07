package com.ahinski.hotels.dto;

import java.util.List;

public class HotelDto {
    
    private Long id;

    private String name;

    private String brand;

    private AdressDto adress;

    private ContactsDto contacts;

    private ArrivalTimeDto arrivalTime;

    private List<AmenityDto> amenities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public AdressDto getAdress() {
        return adress;
    }

    public void setAdress(AdressDto adress) {
        this.adress = adress;
    }

    public ContactsDto getContacts() {
        return contacts;
    }

    public void setContacts(ContactsDto contacts) {
        this.contacts = contacts;
    }

    public ArrivalTimeDto getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTimeDto arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<AmenityDto> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<AmenityDto> amenities) {
        this.amenities = amenities;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((adress == null) ? 0 : adress.hashCode());
        result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
        result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
        result = prime * result + ((amenities == null) ? 0 : amenities.hashCode());
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
        HotelDto other = (HotelDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (adress == null) {
            if (other.adress != null)
                return false;
        } else if (!adress.equals(other.adress))
            return false;
        if (contacts == null) {
            if (other.contacts != null)
                return false;
        } else if (!contacts.equals(other.contacts))
            return false;
        if (arrivalTime == null) {
            if (other.arrivalTime != null)
                return false;
        } else if (!arrivalTime.equals(other.arrivalTime))
            return false;
        if (amenities == null) {
            if (other.amenities != null)
                return false;
        } else if (!amenities.equals(other.amenities))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "HotelDto [id=" + id + ", name=" + name + ", brand=" + brand + ", adress=" + adress + ", contacts="
                + contacts + ", arrivalTime=" + arrivalTime + ", amenities=" + amenities + "]";
    }
}
