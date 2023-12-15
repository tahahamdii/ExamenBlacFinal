package com.example.hamditaha.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bibliotheque")
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class Bibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBiblio;

    @Column(name ="nom")
    private String nom ;
    @Column(name ="adresse")

    private String adresse;
    @Column(name ="telephone")

    private long telephone;

    @OneToMany
    private List<Livre> livres;
}
