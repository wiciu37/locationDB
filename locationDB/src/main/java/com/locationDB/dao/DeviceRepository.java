package com.locationDB.dao;

import com.locationDB.model.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    List<Device> findByLongitude(double longitude);
    List<Device> findByLatitude(double latitude);

    List<Device> findByLongitudeAndLatitude(double longitude, double latitude);

    Device findDeviceById(Long id);
    Device findDeviceByName(String name);

}
