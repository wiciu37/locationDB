package com.locationDB.dao;

import com.locationDB.model.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {


    List<Device> findByLatitude(double latitude);
    List<Device> findByLongitude(double longitude);
    Device findDeviceById(Long id);
    Device findDeviceByName(String name);
}
