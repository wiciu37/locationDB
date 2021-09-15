package com.locationDB.controller;

import com.locationDB.model.DeviceDto;
import com.locationDB.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.*;

@RestController
@RequestMapping("devices")
@Validated
@AllArgsConstructor
public class DeviceController {


    private final DeviceService deviceService;

    //@PostMapping
    @PostMapping("/one")
    public DeviceDto saveDevice(@RequestBody DeviceDto deviceDto)
    {
        deviceService.saveSingleDevice(deviceDto);
        return deviceDto;
    }


    @PostMapping("/many")
    public List<DeviceDto> saveDevices(@RequestBody List<DeviceDto> deviceDtoList)
    {
        deviceService.saveMultipleDevices(deviceDtoList);

        return deviceDtoList;

    }

    //Get methods
    @GetMapping("")
    public ResponseEntity<List<DeviceDto>> getAllDevices()
    {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }


    @GetMapping("/id")
    public DeviceDto findDeviceById(@RequestParam Long id)
    {
        return deviceService.getDeviceById(id);
    }

    @GetMapping("/getDevicesByLatitude/")
    public List<DeviceDto> getDevicesByLatitude(@RequestParam("latitude")@Min(-360) @Max(360) double latitude)
    {
        return deviceService.getDevicesByLatitude(latitude);
    }

    @GetMapping("/getDevicesByLongitude/")
    public List<DeviceDto> getDevicesByLongitude(@RequestParam("longitude")@Min(-360) @Max(360) double longitude)
    {
        return deviceService.getDevicesByLongitude(longitude);
    }

    @GetMapping("/getDevicesByLocation/{longitude}")
    public List<DeviceDto> getDevicesByLocation(@RequestParam("longitude")@Min(-360) @Max(360) double longitude, @RequestParam("latitude")@Min(-360) @Max(360) double latitude)
    {
        return deviceService.getDevicesByLocation(longitude, latitude);
    }

    @GetMapping("/{name}")
    public List<DeviceDto> getDevicesByName(@RequestParam("name") @Min(-360) @Max(360) String name)
    {
        return deviceService.getDevicesByName(name);
    }


}