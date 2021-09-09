package com.locationDB.controller;


import com.locationDB.dao.DeviceRepository;
import com.locationDB.model.Device;
import com.locationDB.model.DeviceDto;
import com.locationDB.service.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.*;

@RestController
@Validated
public class DeviceController {


    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService)
    {
        this.deviceService = deviceService;
    }

    @PostMapping("/saveSingleDevice")
    public ResponseEntity<String> saveDevice(@RequestBody DeviceDto deviceDto)
    {

        return new ResponseEntity<>(deviceService.saveSingleDevice(deviceDto), HttpStatus.OK);
    }

    @PostMapping("/saveMultipleDevices")
    public ResponseEntity<String> saveDevices(@RequestBody List<DeviceDto> deviceDtoList)
    {
        /*
        repository.saveAll(deviceList);
        return new ResponseEntity<>(deviceList.size() + " devices saved..", HttpStatus.OK);
         */

        return new ResponseEntity<>(deviceService.saveMultipleDevices(deviceDtoList), HttpStatus.OK);
    }

    @GetMapping("/getAllDevices")
    public ResponseEntity<List<DeviceDto>> getAllDevices()
    {
        return new ResponseEntity<>(deviceService.getAllDevices(), HttpStatus.OK);
    }


    @GetMapping("/getDeviceById/")
    public ResponseEntity<DeviceDto> findDeviceById(@RequestParam("id")@Min(0) @PathVariable Long id)
    {
        //return new ResponseEntity<>(repository.findDeviceById(id), HttpStatus.OK);
        return new ResponseEntity<DeviceDto>(deviceService.getDeviceById(id), HttpStatus.OK);
    }

    @GetMapping("/getDeviceByLatitude/")
    public ResponseEntity<List<DeviceDto>> getDevicesByLatitude(@RequestParam("latitude")@Min(-360) @Max(360) @PathVariable double latitude)
    {
        //return new ResponseEntity<>(repository.findByLatitude(latitude), HttpStatus.OK);
        return new ResponseEntity<>(deviceService.getDevicesByLatitude(latitude), HttpStatus.OK);
    }

    @GetMapping("/getDevicesByLongitude/")
    public ResponseEntity<List<DeviceDto>> getDevicesByLongitude(@RequestParam("longitude")@Min(-360) @Max(360) @PathVariable double longitude)
    {
        //return new ResponseEntity<>(repository.findByLongitude(longitude), HttpStatus.OK);
        return new ResponseEntity<>(deviceService.getDevicesByLongitude(longitude), HttpStatus.OK);
    }

    @GetMapping("/getDevicesByLocation/")
    public ResponseEntity<List<DeviceDto>> getDevicesByLocation(@RequestParam("longitude")@Min(-360) @Max(360) @PathVariable double longitude, @RequestParam("latitude")@Min(-360) @Max(360) @PathVariable double latitude)
    {
        /*
        Set<Device> set = new HashSet<>();

        for(Device d : repository.findByLatitude(latitude))
        {
            if(d.getLongitude() == longitude)
                set.add(d);
        }

        for(Device d : repository.findByLongitude(longitude))
        {
            if(d.getLatitude() == latitude)
                set.add(d);
        }

        List<Device> resultList = new ArrayList<>(set);

        return new ResponseEntity<>(resultList, HttpStatus.OK);
         */
        return new ResponseEntity<>(deviceService.getDevicesByLocation(longitude, latitude), HttpStatus.OK);
    }

    @GetMapping("/getDeviceByName/")
    public ResponseEntity<DeviceDto> getDeviceByName(@RequestParam("name") @Min(-360) @Max(360) @PathVariable String name)
    {
        //return new ResponseEntity<>(repository.findDeviceByName(name), HttpStatus.OK);
        return new ResponseEntity<>(deviceService.getDeviceByName(name), HttpStatus.OK);
    }


}