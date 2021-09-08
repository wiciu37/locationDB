package com.locationDB.controllers;


import com.locationDB.db.DeviceRepository;
import com.locationDB.models.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceController {

    private final DeviceRepository repository;

    DeviceController(DeviceRepository repository)
    {
        this.repository = repository;
    }

    @PostMapping("/add")
    @ResponseBody
    public Device addDevice(@RequestBody Device newDevice)
    {
        return repository.save(newDevice);
    }
    
}
