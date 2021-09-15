package com.locationDB.model;

import lombok.Data;

@Data
public class DeviceDto {

    private long id;
    private String name;
    private double longitude;
    private double latitude;
}
