package com.locationDB.service;

import com.locationDB.dao.DeviceRepository;
import com.locationDB.model.Device;
import com.locationDB.model.DeviceDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository repository;

    private final ModelMapper mapper;

    //Get methods
    @Transactional
    public List<DeviceDto> getAllDevices()
    {

        List<DeviceDto> result = StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return result;


    }

    @Transactional
    public DeviceDto getDeviceById(Long id)
    {
        return convertToDto(repository.findDeviceById(id));
    }

    public List<DeviceDto> getDevicesByLongitude(double longitude)
    {
        List<DeviceDto> result = StreamSupport.stream(repository.findByLongitude(longitude).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return result;

    }

    public List<DeviceDto> getDevicesByLatitude(double latitude)
    {
        List<DeviceDto> result = StreamSupport.stream(repository.findByLatitude(latitude).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return result;

    }

    public List<DeviceDto> getDevicesByLocation(double longitude, double latitude)
    {

        List<DeviceDto> result = StreamSupport.stream(repository.findByLongitudeAndLatitude(longitude, latitude).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return result;
        /*
        List<DeviceDto> result = new ArrayList<>();

        for(Device d : repository.findByLongitudeAndLatitude(longitude, latitude))
        {
            result.add(convertToDto(d));
        }

        return result;

         */
    }

    public List<DeviceDto> getDevicesByName(String name)
    {
        List<DeviceDto> result = StreamSupport.stream(repository.findDevicesByName(name).spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return result;
    }


    //Post methods
    public Device saveSingleDevice(DeviceDto deviceDto)
    {
        repository.save(convertToEntity(deviceDto));

        return convertToEntity(deviceDto);
    }

    /*
    public List<Device> saveMultipleDevices(List<DeviceDto> deviceDtos)
    {
        /*
        Device device;
        for(DeviceDto d : deviceDtos)
        {
            device = convertToEntity(d);
            repository.save(device);
        }



        repository.saveAll(deviceDtos.stream().map(this::convertToEntity).collect(Collectors.toList()));

        return deviceDtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
    */

    public List<Device> saveMultipleDevices(List<DeviceDto> deviceDtos)
    {

        List<Device> result =  deviceDtos.stream().map(this::convertToEntity).collect(Collectors.toList());
        repository.saveAll(result);

        return result;
    }


    //conversion
    private DeviceDto convertToDto(Device device)
    {
        DeviceDto deviceDto = mapper.map(device, DeviceDto.class);
        return deviceDto;
    }

    private Device convertToEntity(DeviceDto deviceDto)
    {
        Device device = mapper.map(deviceDto, Device.class);

        return device;
    }
}
