package com.locationDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "DEVICE_DB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    //id of device name + location
    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;

    //names of devices are unique
    private String name;
    private double longitude;
    private double latitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name= "+name+
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
