package com.omrigal.mydashboardbackend.controller;

import com.omrigal.mydashboardbackend.exception.ClientLoginRequestDeniedException;
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
    List<OnlineClientResponse> all() {
        return repository.findAllOnlineClients().stream().map(OnlineClientResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/client-details/{username}")
    ClientDetailsResponse one(@PathVariable String username) {
        Client client = repository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException(username));
        return new ClientDetailsResponse(client);
    }

    @PostMapping("/register-client")
    ClientDetailsResponse newClient(@RequestBody ClientRegisterRequest newClient) {
        Client client = repository.save(new Client(newClient));
        return new ClientDetailsResponse(client);
    }

    @PostMapping("/login-client")
    ClientLoginResponse login(@RequestBody ClientLoginRequest request) {
        String email = request.getEmail();
        Client client = repository.findByEmail(email).orElseThrow(() -> new ClientNotFoundException(email));
        if (!client.getPassword().equals(request.getPassword())) {
            throw new ClientLoginRequestDeniedException("Incorrect password");
        }
        repository.loginClientById(client.getId(), new Date(System.currentTimeMillis()));
        return new ClientLoginResponse(client);
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
