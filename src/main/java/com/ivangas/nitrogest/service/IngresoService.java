package com.ivangas.nitrogest.service;

import com.ivangas.nitrogest.model.Entidad;
import com.ivangas.nitrogest.model.Ingresos;
import com.ivangas.nitrogest.repository.IngresosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class IngresoService {

    @Autowired
    private IngresosRepository ingresosRepository;

    /**
     * Obtener todos los ingresos
     * @return Ingresos
     */
    public List<Ingresos> getIngresos() {
        log.info("Se obtienen todos los ingresos");
        return ingresosRepository.findAll();
    }

    /**
     * Guardar Ingresos
     * @param ingresos
     * @return Ingresos
     *
     */
    public Ingresos guardarIngresos(Ingresos ingresos) {
        log.info("Se guarda el ingreso {}", ingresos.getId());
        return ingresosRepository.save(ingresos);
    }

    /**
     * Se obtiene un ingreso por id
     * @param id
     * @return Ingresos
     */
    public Ingresos getIngresosById(Long id){
        log.info("Se obtiene la siguiente entidad: {}", id);

        return ingresosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Ingreso no encontrado"));

    }

    /**
     * Guardamos el ingreso
     * @param ingresos
     * @return ingreso
     */
    public Ingresos actualizarIngreso(Ingresos ingresos) {
        Long idIngreso = ingresos.getId();
        log.info("Se procede a actualizar el ingreso con id: {} ", idIngreso);
        Ingresos i = getIngresosById(idIngreso);
        i.setFecha(ingresos.getFecha());
        i.setTipoIngreso(ingresos.getTipoIngreso());
        i.setEntidad(ingresos.getEntidad());
        i.setPagador(ingresos.getPagador());
        i.setOrigen(ingresos.getOrigen());
        i.setCantidad(ingresos.getCantidad());
        i.setEstadoIngreso(ingresos.getEstadoIngreso());

        return ingresosRepository.save(i);
    }

}
