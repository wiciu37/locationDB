package com.locationDB.service;

import com.locationDB.dao.DeviceRepository;
import com.locationDB.model.Device;
import com.locationDB.model.DeviceDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    private DeviceRepository repository;

    public DeviceService(DeviceRepository repository)
    {
        this.repository = repository;
    }


    //Get methods
    public List<DeviceDto> getAllDevices()
    {
        List<DeviceDto> result = new ArrayList<>();

        for(Device d : repository.findAll())
        {
            result.add(convertToDto(d));
        }

        return result;
    }

    public DeviceDto getDeviceById(Long id)
    {
        DeviceDto deviceDto = convertToDto(repository.findDeviceById(id));

        return deviceDto;
    }

    public List<DeviceDto> getDevicesByLongitude(double longitude)
    {

        List<DeviceDto> result = new ArrayList();
        for(Device d : repository.findByLongitude(longitude))
        {
            result.add(convertToDto(d));
        }
        return result;
    }

    public List<DeviceDto> getDevicesByLatitude(double latitude)
    {
        List<DeviceDto> result = new ArrayList();
        for(Device d : repository.findByLatitude(latitude))
        {
            result.add(convertToDto(d));
        }
        return result;
    }

    public List<DeviceDto> getDevicesByLocation(double longitude, double latitude)
    {
        List<DeviceDto> result = new ArrayList<>();

        for(Device d : repository.findByLongitudeAndLatitude(longitude, latitude))
        {
            result.add(convertToDto(d));
        }

        return result;
    }

    public DeviceDto getDeviceByName(String name)
    {
        return convertToDto(repository.findDeviceByName(name));
    }


    //Post methods
    public String saveSingleDevice(DeviceDto deviceDto)
    {
        Device device = convertToEntity(deviceDto);
        repository.save(device);
        return device.toString() +" record saved...";
    }

    public String saveMultipleDevices(List<DeviceDto> deviceDtos)
    {
        Device device;
        for(DeviceDto d : deviceDtos)
        {
            device = convertToEntity(d);
            repository.save(device);
        }

        return deviceDtos.size() + " devices saved..";
    }

    //conversion
    private DeviceDto convertToDto(Device device)
    {
        DeviceDto deviceDto = mapper.map(device, DeviceDto.class);
        /*
        deviceDto.setId(device.getId());
        deviceDto.setLatitude(device.getLatitude());
        deviceDto.setLongitude(device.getLongitude());
        deviceDto.setName(device.getName());


         */
        return deviceDto;
    }

    private Device convertToEntity(DeviceDto deviceDto)
    {
        Device device = mapper.map(deviceDto, Device.class);

        return device;
    }

    @Autowired
    private ModelMapper mapper;
}
