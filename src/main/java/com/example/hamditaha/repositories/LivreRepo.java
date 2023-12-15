package com.example.hamditaha.repositories;

import com.example.hamditaha.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepo extends JpaRepository<Livre, Long> {
}
