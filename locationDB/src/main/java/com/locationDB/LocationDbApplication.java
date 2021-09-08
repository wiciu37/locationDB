package com.locationDB;

import com.locationDB.db.DeviceRepository;
import com.locationDB.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationDbApplication {


	public static void main(String[] args) {
		SpringApplication.run(LocationDbApplication.class, args);
	}

}
