package com.example.bankaccountrest.repository;

import com.example.bankaccountrest.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
    // Spring Data JPA provides all basic CRUD operations automatically
    // including findAll(), findById(), save(), deleteById()
}