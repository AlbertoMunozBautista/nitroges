package com.ivangas.nitrogest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstadoIngreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estadoIngreso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoIngreso() {
        return estadoIngreso;
    }

    public void setEstadoIngreso(String estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }
}
