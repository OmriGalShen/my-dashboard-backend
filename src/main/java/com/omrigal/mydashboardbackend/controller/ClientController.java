package com.omrigal.mydashboardbackend.controller;

import com.omrigal.mydashboardbackend.exception.ClientLoginRequestDenied;
import com.omrigal.mydashboardbackend.exception.ClientNotFoundException;
import com.omrigal.mydashboardbackend.model.*;
import com.omrigal.mydashboardbackend.repository.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientController {
    private final UsersRepository repository;

    public ClientController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/online-clients")
    List<OnlineClient> all() {
        return repository.findAllOnlineClients().stream().map(OnlineClient::new).collect(Collectors.toList());
    }

    @GetMapping("/client-details/{username}")
    ClientDetails one(@PathVariable String username) {
        Client client = repository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException(username));
        return new ClientDetails(client);
    }

    @PostMapping("/register-client")
    ClientDetails newClient(@RequestBody ClientRegisterRequest newClient) {
        Client client = repository.save(new Client(newClient));
        return new ClientDetails(client);
    }

    @PostMapping("/login-client")
    void login(@RequestBody ClientLoginRequest request) {
        String email = request.getEmail();
        Client client = repository.findByEmail(email).orElseThrow(() -> new ClientNotFoundException(email));
        if (!client.getPassword().equals(request.getPassword())) {
            throw new ClientLoginRequestDenied("Incorrect password");
        }
        repository.loginClientById(client.getId(), new Date(System.currentTimeMillis()));
    }

    @PostMapping("/logout-client/{username}")
    void logout(@PathVariable String username) {
        Client client = repository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException(username));
        repository.updateIsOnlineById(client.getId(), false, new Date(System.currentTimeMillis()));
    }

    @DeleteMapping("/client/{username}")
    void deleteClient(@PathVariable String username) {
        Client client = repository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException(username));
        repository.deleteById(client.getId());
    }
}
