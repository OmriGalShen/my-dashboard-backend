package com.omrigal.mydashboardbackend.config;

import com.omrigal.mydashboardbackend.model.Client;
import com.omrigal.mydashboardbackend.model.ClientRegisterRequest;
import com.omrigal.mydashboardbackend.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClientRepository repository) {

        return args -> {
            repository.deleteAll();
            for (int i = 0; i < 12; i++) {
                ClientRegisterRequest request = new ClientRegisterRequest("dummy" + i, "1234", "dummy" + i + "@gmail.com");
                Client c = new Client(request);
                c.setIsOnline(true);
                c.setLoginTime(new Date(System.currentTimeMillis()));
                c.setIp("localhost");
                log.info("Preloading " + repository.save(c));
            }
        };
    }
}
