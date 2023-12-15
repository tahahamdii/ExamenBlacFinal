package com.example.hamditaha.controller;

import com.example.hamditaha.entity.Bibliotheque;
import com.example.hamditaha.entity.Utilisateur;
import com.example.hamditaha.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExamController {
    @Autowired
    private ExamenService examenService;

    @PostMapping("/addBib")
    public ResponseEntity<List<Bibliotheque>> addBibliotheques(@RequestBody List<Bibliotheque> bibliotheques){
        List<Bibliotheque> savedBibs = examenService.saveAll(bibliotheques);
        return new ResponseEntity<>(savedBibs , HttpStatus.CREATED);
    }
    @PostMapping("/ajouterLecteurs")
    public ResponseEntity<List<Utilisateur>> ajouterLecteurs(@RequestBody List<Utilisateur> lecteurs) {
        List<Utilisateur> lecteursMisAJour = examenService.ajouterLecteurs(lecteurs);
        return new ResponseEntity<>(lecteursMisAJour, HttpStatus.OK);
    }
}
