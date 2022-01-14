package com.omrigal.mydashboardbackend.controller;

import com.omrigal.mydashboardbackend.exception.ClientNotFoundException;
import com.omrigal.mydashboardbackend.model.Client;
import com.omrigal.mydashboardbackend.repository.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final UsersRepository repository;

    public ClientController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clients")
    List<Client> all() {
        return repository.findAll();
    }

    @PostMapping("/clients")
    Client newClient(@RequestBody Client newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/clients/{id}")
    Client one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PutMapping("/clients/{id}")
    Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {

        return repository.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    return repository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return repository.save(newClient);
                });
    }

    @DeleteMapping("/clients/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
