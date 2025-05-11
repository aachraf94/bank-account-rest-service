package com.example.bankaccountrest.controller;

import com.example.bankaccountrest.model.Compte;
import com.example.bankaccountrest.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping
    public ResponseEntity<List<Compte>> recupererComptes() {
        List<Compte> comptes = compteService.recupererComptes();
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> recupererCompte(@PathVariable String id) {
        Optional<Compte> compte = compteService.recupererCompte(id);
        return compte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Compte> ajouterCompte(@RequestBody Compte compte) {
        Compte nouveauCompte = compteService.ajouterCompte(compte);
        return new ResponseEntity<>(nouveauCompte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compte> modifierCompte(@RequestBody Compte compte, @PathVariable String id) {
        Compte compteModifie = compteService.modifierCompte(compte, id);
        if (compteModifie != null) {
            return new ResponseEntity<>(compteModifie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCompte(@PathVariable String id) {
        compteService.supprimerCompte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}