package com.omrigal.mydashboardbackend.config;

import com.omrigal.mydashboardbackend.model.Client;
import com.omrigal.mydashboardbackend.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UsersRepository repository) {

        return args -> {
            repository.deleteAll();
            log.info("Preloading " + repository.save(new Client("Omri1")));
            log.info("Preloading " + repository.save(new Client("Omri2")));
        };
    }
}
