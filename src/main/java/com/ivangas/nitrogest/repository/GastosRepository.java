package com.ivangas.nitrogest.repository;

import com.ivangas.nitrogest.model.Entidad;
import com.ivangas.nitrogest.model.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastosRepository extends JpaRepository<Gastos, Long> {
}
