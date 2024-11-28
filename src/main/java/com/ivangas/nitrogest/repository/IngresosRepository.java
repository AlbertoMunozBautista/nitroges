package com.ivangas.nitrogest.repository;

import com.ivangas.nitrogest.model.Gastos;
import com.ivangas.nitrogest.model.Ingresos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresosRepository extends JpaRepository<Ingresos, Long> {
}
