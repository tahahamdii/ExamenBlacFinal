package com.example.hamditaha.service;

import com.example.hamditaha.entity.Bibliotheque;
import com.example.hamditaha.entity.Livre;
import com.example.hamditaha.entity.Utilisateur;
import com.example.hamditaha.repositories.BibliothequeRepo;
import com.example.hamditaha.repositories.LivreRepo;
import com.example.hamditaha.repositories.UtilisateurRepo;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExamenService {
    @Autowired
    private BibliothequeRepo bibliothequeRepo;
    @Autowired
    private LivreRepo livreRepository;
    @Autowired
    private UtilisateurRepo utilisateurRepository;



    public Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque){
        return bibliothequeRepo.save(bibliotheque);
    }


    public List<Bibliotheque> saveAll(List<Bibliotheque> bibliotheques) {
            return bibliothequeRepo.saveAll(bibliotheques);
    }

    public List<Utilisateur> ajouterLecteurs(List<Utilisateur> lecteurs) {
            Utilisateur nouvelUtilisateur1 = new Utilisateur("Aloui", "Ala", "2023-01-12", "2023-02-12", "LECTEUR");
            Utilisateur nouvelUtilisateur2 = new Utilisateur("Farhat", "Farah", "2022-12-15", "2023-12-15", "ACTIF");
            Utilisateur nouvelUtilisateur3 = new Utilisateur("Zekri", "Zakaria", "2022-10-13", "2023-02-13", "LECTEUR");

            lecteurs.add(nouvelUtilisateur1);
            lecteurs.add(nouvelUtilisateur2);
            lecteurs.add(nouvelUtilisateur3);

            return lecteurs;


        }


    public String affecterLivreALecteur(long idLivre, long idLecteur) {
        Optional<Livre> livreOptional = livreRepository.findById(idLivre);
        Optional<Utilisateur> lecteurOptional = utilisateurRepository.findById(idLecteur);

        if (livreOptional.isPresent() && lecteurOptional.isPresent()) {
            Livre livre = livreOptional.get();
            Utilisateur lecteur = lecteurOptional.get();

            if (livre.isReserve()) {
                return "Le livre " + livre.getNom() + " est déjà réservé.";
            }

            // Réserver le livre pour le lecteur
            livre.setReserve(true);
            livre.setLecteur(lecteur);
            lecteur.getLivres().add(livre);

            livreRepository.save(livre);
            utilisateurRepository.save(lecteur);

            return "L'affectation du livre " + livre.getNom() + " au lecteur " + lecteur.getNom() + " est effectuée avec succès.";
        } else {
            return "Le livre ou le lecteur spécifié n'existe pas.";
        }
    }

}

