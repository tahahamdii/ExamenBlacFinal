package com.example.hamditaha.service;

import com.example.hamditaha.entity.Bibliotheque;
import com.example.hamditaha.entity.Livre;
import com.example.hamditaha.entity.Utilisateur;

import java.util.List;

public interface iExamenService {
    Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque);
    List<Utilisateur> ajouterLecteurs(List<Utilisateur> utilisateurs);
    Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(Livre l, String nomBibliotheque);
    String affecterLivreALecteur(long idLivre, long idLecteur);
}
