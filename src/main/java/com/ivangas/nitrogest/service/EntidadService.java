package com.ivangas.nitrogest.service;

import com.ivangas.nitrogest.model.Entidad;
import com.ivangas.nitrogest.repository.EntidadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Slf4j
@Service
public class EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    /**
     * Obtener todas las entidades
     * @return entidad
     */
    public List<Entidad> getEntidad() {
        log.info("Se obtienen todas las entidades");
        return entidadRepository.findAll();
    }

    /**
     * Guardar entidad
     * @param entidad
     * @return entidad
     *
     */
    public Entidad guardarEntidad(Entidad entidad) {
        log.info("Se guarda la entidad {}", entidad.getId());
        return entidadRepository.save(entidad);
    }

    /**
     * Se obtiene una entidad por id
     * @param id
     * @return entidad
     */
    public Entidad getEntidadById(Long id){
        log.info("Se obtiene la siguiente entidad: {}", id);

        return entidadRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Entidad no encontrada"));

    }

    /**
     * Guardamos la entidad
     * @param entidad
     * @return entidad
     */
    public Entidad actualizarEntidad(Entidad entidad) {
        Long idEntidad = entidad.getId();
        log.info("Se procede a actualizar la entidad con id: {} ", idEntidad);
        Entidad e = getEntidadById(idEntidad);
        e.setNombre(entidad.getNombre());
        e.setEmail(entidad.getEmail());
        e.setTelefono(entidad.getTelefono());
        e.setDireccion(entidad.getDireccion());
        e.setCiudad(entidad.getCiudad());
        e.setProvincia(entidad.getProvincia());
        e.setCodigo_postal(entidad.getCodigo_postal());
        e.setPais(entidad.getPais());
        e.setNif_cif(entidad.getNif_cif());
        e.setTipo(entidad.getTipo());
        e.setWeb(entidad.getWeb());
        return entidadRepository.save(e);
    }


}