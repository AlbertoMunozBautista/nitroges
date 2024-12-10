package com.ivangas.nitrogest.repository;

import com.ivangas.nitrogest.model.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GastosRepository extends JpaRepository<Gastos, Long> {
    Optional<Gastos> findById(Long id);
}
