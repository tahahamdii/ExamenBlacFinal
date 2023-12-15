package com.example.hamditaha.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "Livre")
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLivre;
    @Column(name = "nom")
    private String nom ;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")

    private TypeLivre type ;
    @Column(name = "dateEmission")

    private LocalDate dateEmission;
    @Column(name = "reserve")

    private boolean reserve ;
    @Column(name = "dateReservation")

    private LocalDate dateReservation;
    @Column(name = "lecteur")
    @OneToOne(mappedBy = "livre", cascade = CascadeType.ALL)
    private Utilisateur lecteur;
    @ManyToOne
    @Column(name = "auteur")
    private Utilisateur auteur ;



}
