package com.ivangas.nitrogest.repository;

import com.ivangas.nitrogest.model.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {

    Optional<Entidad> findById(Long id);

}
