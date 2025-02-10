package com.ahinski.hotels.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class HotelDto {
    
    private Long id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    private String brand;

    private AddressDto address;

    private ContactsDto contacts;

    private ArrivalTimeDto arrivalTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> amenities;

    public HotelDto() {}

    public HotelDto(Long id, String name, String description, String brand, AddressDto address, ContactsDto contacts,
            ArrivalTimeDto arrivalTime, List<String> amenities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.address = address;
        this.contacts = contacts;
        this.arrivalTime = arrivalTime;
        this.amenities = amenities;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
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

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
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
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
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
        return "HotelDto [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand
                + ", address=" + address + ", contacts=" + contacts + ", arrivalTime=" + arrivalTime + ", amenities="
                + amenities + "]";
    }
}