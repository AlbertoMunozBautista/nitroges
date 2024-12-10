package com.ivangas.nitrogest.service;

import com.ivangas.nitrogest.model.Gastos;
import com.ivangas.nitrogest.repository.GastosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class GastosService {

    @Autowired
    private GastosRepository gastosRepository;

    /**
     * Obtener todas los gastos
     * @return gatos
     */
    public List<Gastos> getGastos() {
        log.info("Se obtienen todos los gastos");
        return gastosRepository.findAll();
    }

    /**
     * Guardar gastos
     * @param gastos
     * @return gastos
     *
     */
    public Gastos guardarGastos(Gastos gastos) {
        log.info("Se guarda el gasto {}", gastos.getId());
        return gastosRepository.save(gastos);
    }

    /**
     * Se obtiene una entidad por id
     * @param id
     * @return gastos
     */
    public Gastos getGastoById(Long id) {
        log.info("Se obtiene el siguiente gasto: {}", id);

        return gastosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Gasto no encontrado"));

    }

    /**
     * Guardamos el gasto
     * @param gasto
     * @return gastos
     */
    public Gastos actualizarGasto(Gastos gasto) {
        Long idGasto = gasto.getId();
        log.info("Se procede a actualizar el gasto con id: {} ", idGasto);
        Gastos gas = getGastoById(idGasto);
        gas.setFecha(gasto.getFecha());
        gas.setHora(gasto.getHora());
        gas.setConcepto(gasto.getConcepto());
        gas.setCantidad(gasto.getCantidad());
        gas.setUbicacion(gasto.getUbicacion());
        gas.setObservacion(gasto.getObservacion());
        gas.setFrecuencia(gasto.getFrecuencia());
        gas.setFamilia(gasto.getFamilia());
        gas.setEntidad(gasto.getEntidad());
        gas.setMetodoPago(gasto.getMetodoPago());
        return gastosRepository.save(gas);
    }



}
