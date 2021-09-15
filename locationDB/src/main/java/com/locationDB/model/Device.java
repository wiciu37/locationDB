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
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private double longitude;
    private double latitude;

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
