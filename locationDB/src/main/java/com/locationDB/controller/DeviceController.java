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


    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceRepository repository;


    @PostMapping("/saveSingleDevice")
    public ResponseEntity<String> saveDevice(@RequestBody DeviceDto deviceDto)
    {
        /*
        //Device device = convertToEntity(deviceDto);
        repository.save(device);
        return new ResponseEntity<>(device.toString() +" record saved..", HttpStatus.OK);
        */
        //deviceService.saveSingleDevice(deviceDto);

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
    public ResponseEntity<List<Device>> getAllDevices()
    {
        return new ResponseEntity<>(((List<Device>) repository.findAll()), HttpStatus.OK);
    }


    @GetMapping("/getDeviceById/{id}")
    public ResponseEntity<DeviceDto> findDeviceById(@RequestParam("id")@Min(0) @PathVariable Long id)
    {
        //return new ResponseEntity<>(repository.findDeviceById(id), HttpStatus.OK);
        return new ResponseEntity<DeviceDto>(deviceService.getDeviceById(id), HttpStatus.OK);
    }

    @GetMapping("/getDeviceByLatitude/{latitude}")
    public ResponseEntity<List<DeviceDto>> getDevicesByLatitude(@RequestParam("latitude")@Min(-360) @Max(360) @PathVariable double latitude)
    {
        //return new ResponseEntity<>(repository.findByLatitude(latitude), HttpStatus.OK);
        return new ResponseEntity<>(deviceService.getDevicesByLatitude(latitude), HttpStatus.OK);
    }

    @GetMapping("/getDevicesByLongitude/{longitude}")
    public ResponseEntity<List<DeviceDto>> getDevicesByLongitude(@RequestParam("longitude")@Min(-360) @Max(360) @PathVariable double longitude)
    {
        //return new ResponseEntity<>(repository.findByLongitude(longitude), HttpStatus.OK);
        return new ResponseEntity<>(deviceService.getDevicesByLongitude(longitude), HttpStatus.OK);
    }

    @GetMapping("/getDevicesByLocation/{longitude}/{latitude}")
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

    @GetMapping("/getDeviceByName/{name}")
    public ResponseEntity<DeviceDto> getDeviceByName(@RequestParam("name") @Min(-360) @Max(360) @PathVariable String name)
    {
        //return new ResponseEntity<>(repository.findDeviceByName(name), HttpStatus.OK);
        return new ResponseEntity<>(deviceService.getDeviceByName(name), HttpStatus.OK);
    }


}