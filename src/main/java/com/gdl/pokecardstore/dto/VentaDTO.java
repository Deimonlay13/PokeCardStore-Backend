package com.gdl.pokecardstore.dto;

import java.time.LocalDateTime;

public class VentaDTO {

    private Long idVenta;
    private Long idUsuario;
    private Double total;
    private LocalDateTime fechaCreacion;

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public VentaDTO(Long idVenta, Long idUsuario, Double total, LocalDateTime fechaCreacion) {
        this.idVenta = idVenta;
        this.idUsuario = idUsuario;
        this.total = total;
        this.fechaCreacion = fechaCreacion;
    }

}
