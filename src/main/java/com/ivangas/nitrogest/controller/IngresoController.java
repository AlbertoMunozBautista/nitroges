package com.ivangas.nitrogest.controller;


import com.ivangas.nitrogest.model.Ingresos;
import com.ivangas.nitrogest.service.IngresoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService){this.ingresoService = ingresoService;}

    //guardar ingreso
    @PostMapping("/insertar-ingreso")
    public ResponseEntity<Ingresos> insertIngreso(@RequestBody Ingresos i) {
        try {
            Ingresos ingresos = ingresoService.guardarIngresos(i);
            return ResponseEntity.ok(ingresos);
        } catch (IllegalArgumentException | EntityNotFoundException a) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Obtener ingresos
    @GetMapping("/obtener-ingresos")
    public List<Ingresos> getIngresos() {
        return ingresoService.getIngresos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingresos> getIngreso(@PathVariable Long id) {
        try {
            Ingresos ingresos = ingresoService.getIngresosById(id);
            return ResponseEntity.ok(ingresos);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{ingresos}")
    public Ingresos actualizarIngresos(@RequestBody Ingresos i) {
        return ingresoService.actualizarIngreso(i);
    }

}
