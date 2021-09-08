package com.locationDB.db;

import com.locationDB.models.Device;
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
            log.info("Preloading " + repository.save(new Device(52.3, 22.4)));
            log.info("Preloading " + repository.save(new Device(13, -10.3)));
        };

    }
}