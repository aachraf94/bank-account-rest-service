package com.example.bankaccountrest.service;

import com.example.bankaccountrest.model.Compte;
import com.example.bankaccountrest.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    private final CompteRepository compteRepository;

    @Autowired
    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public List<Compte> recupererComptes() {
        return compteRepository.findAll();
    }

    public Optional<Compte> recupererCompte(String id) {
        return compteRepository.findById(id);
    }

    public Compte ajouterCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte modifierCompte(Compte compteDetails, String id) {
        // Check if the account exists
        Optional<Compte> optionalCompte = compteRepository.findById(id);

        if (optionalCompte.isPresent()) {
            Compte existingCompte = optionalCompte.get();

            // Update account details
            existingCompte.setProprietaire(compteDetails.getProprietaire());
            existingCompte.setSolde(compteDetails.getSolde());
            existingCompte.setType(compteDetails.getType());

            // Save updated account
            return compteRepository.save(existingCompte);
        } else {
            // You could throw an exception here or handle the case where the account doesn't exist
            return null;
        }
    }

    public void supprimerCompte(String id) {
        compteRepository.deleteById(id);
    }
}