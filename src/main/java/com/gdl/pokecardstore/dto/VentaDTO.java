package com.gdl.pokecardstore.dto;

import java.time.LocalDateTime;

public class VentaDTO {

    private Long idVenta;
    private Long idCliente;
    private Double total;
    private LocalDateTime fechaCreacion;


    public VentaDTO(Long idVenta, Long idCliente, Double total, LocalDateTime fechaCreacion) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.total = total;
        this.fechaCreacion = fechaCreacion;
    }

    public VentaDTO() {
    // Constructor vacío necesario para Spring/Jackson
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdUsuario() {
        return idCliente;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idCliente = idUsuario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
