package com.ahinski.hotels.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adress adress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contacts contacts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_time_id", referencedColumnName = "id")
    private ArrivalTime arrivalTime;

    @ManyToMany
    @JoinTable(
        name = "hotels_amenities",
        joinColumns = @JoinColumn(name = "hotel_id"),
        inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<Amenity> amenities;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Adress getAdress() {
        return adress;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public ArrivalTime getArrivalTime() {
        return arrivalTime;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setArrivalTime(ArrivalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", brand=" + brand + ", adress=" + adress + ", contacts="
                + contacts + ", arrivalTime=" + arrivalTime + ", amenities=" + amenities + "]";
    }
}
