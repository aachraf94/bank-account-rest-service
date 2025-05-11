package com.example.bankaccountrest.config;

import com.example.bankaccountrest.model.Compte;
import com.example.bankaccountrest.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CompteRepository compteRepository;

    @Autowired
    public DataInitializer(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public void run(String... args) {
        // Add some sample accounts
        compteRepository.save(new Compte("C001", "Ali Ben Mohamed", 5000.0, "Courant"));
        compteRepository.save(new Compte("C002", "Fatma Ben Ahmed", 12500.0, "Epargne"));
        compteRepository.save(new Compte("C003", "Omar Ben Ali", 3200.0, "Courant"));

        System.out.println("Sample data has been loaded");
    }
}