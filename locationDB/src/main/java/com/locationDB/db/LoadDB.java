package com.locationDB.db;

import com.locationDB.dao.DeviceRepository;
import com.locationDB.model.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);


    @Bean
    CommandLineRunner initDatabase(DeviceRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Device(1L,"phone1",  1.1, 1)));
            log.info("Preloading " + repository.save(new Device(2L,"phone1", 1.1, -1)));
            log.info("Preloading " + repository.save(new Device(3L,"phone2", 1.1, -1)));
        };



    }
}