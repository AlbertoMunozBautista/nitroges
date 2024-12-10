package com.ivangas.nitrogest.controller;


import com.ivangas.nitrogest.model.Gastos;
import com.ivangas.nitrogest.service.GastosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastosController {

    private final GastosService gastosService;

    public GastosController(GastosService gastosService){this.gastosService = gastosService;}

    //guardar gastos
    @PostMapping("/insertar-gasto")
    public ResponseEntity<Gastos> insertGasto(@RequestBody Gastos g) {
        try {
            Gastos gastos = gastosService.guardarGastos(g);
            return ResponseEntity.ok(gastos);
        } catch (IllegalArgumentException | EntityNotFoundException a) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Obtener ingresos
    @GetMapping("/obtener-gastos")
    public List<Gastos> getGastos() {
        return gastosService.getGastos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gastos> getGasto(@PathVariable Long id) {
        try {
            Gastos gastos = gastosService.getGastoById(id);
            return ResponseEntity.ok(gastos);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{gastos}")
    public Gastos actualizarIngresos(@RequestBody Gastos g) {
        return gastosService.actualizarGasto(g);
    }

}
