package com.example.hamditaha.entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser ;
    @Column(name = "nom")
    private String nom ;
    @Column(name = "prenom")

    private String Prenom ;
    @Column(name = "nationalite")

    private String nationalite;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role ;
    @Column(name = "dateD")

    private LocalDate dateDebutabonnement;
    @Column(name = "dateF")

    private LocalDate dateFinabonnement;
    @Column(name = "etat")
    @Enumerated(EnumType.STRING)
    private Etat etat ;

    @Column(name = "livre")
    @OneToOne
    private Livre livre;
    @OneToMany(mappedBy = "auteur")
    private List<Livre> livres;


    public Utilisateur(String aloui, String ala, String date, String date1, String lecteur) {

    }
}
