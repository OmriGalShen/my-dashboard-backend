package com.omrigal.mydashboardbackend.repository;

import com.omrigal.mydashboardbackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Client, Long> {
}
