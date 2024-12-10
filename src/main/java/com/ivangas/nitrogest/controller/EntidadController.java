package com.ivangas.nitrogest.controller;


import com.ivangas.nitrogest.model.Entidad;
import com.ivangas.nitrogest.service.EntidadService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {

    private final EntidadService entidadService;

    public EntidadController(EntidadService entidadService){this.entidadService = entidadService;}

    //guardar entidad
    @PostMapping("/insertar-entidad")
    public ResponseEntity<Entidad> insertEntidad(@RequestBody Entidad e) {
        try {
            Entidad entidad = entidadService.guardarEntidad(e);
            return ResponseEntity.ok(entidad);
        } catch (IllegalArgumentException | EntityNotFoundException a) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Obtener entidades
    @GetMapping("/obtener-entidades")
    public List<Entidad> getEntidad() {
        return entidadService.getEntidad();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entidad> getEntidad(@PathVariable Long id) {
        try {
            Entidad entidad = entidadService.getEntidadById(id);
            return ResponseEntity.ok(entidad);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public Entidad actualizarEntidad(@RequestBody Entidad e) {
        return entidadService.actualizarEntidad(e);
    }

}
