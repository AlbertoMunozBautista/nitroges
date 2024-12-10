package com.ivangas.nitrogest.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ingresos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String pagador;
    private Float cantidad;
    private String origen;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "tipo_ingreso_id")
    private TipoIngreso tipoIngreso;

    @ManyToOne
    @JoinColumn(name = "estado_ingreso_id")
    private  EstadoIngreso estadoIngreso;

    @ManyToOne
    @JoinColumn(name = "entidad_id")
    private Entidad entidad;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public EstadoIngreso getEstadoIngreso() {
        return estadoIngreso;
    }

    public void setEstadoIngreso(EstadoIngreso estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }

    public TipoIngreso getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(TipoIngreso tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
