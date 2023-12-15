package com.example.hamditaha.repositories;

import com.example.hamditaha.entity.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BibliothequeRepo extends JpaRepository<Bibliotheque,Long> {
}
