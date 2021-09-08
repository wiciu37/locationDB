package com.locationDB.models;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    private double longitude;
    private double latitude;

    public Device(){}

    public Device(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
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
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
