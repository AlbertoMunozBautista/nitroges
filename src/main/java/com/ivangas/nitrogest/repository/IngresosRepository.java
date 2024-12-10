package com.ivangas.nitrogest.repository;

import com.ivangas.nitrogest.model.Ingresos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngresosRepository extends JpaRepository<Ingresos, Long> {

    Optional<Ingresos> findById(Long id);

}
