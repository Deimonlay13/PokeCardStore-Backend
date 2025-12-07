package com.gdl.pokecardstore.dto;

public class DetalleDTO {
    private Long idDetalle;
    private Long idVenta;
    private Long idCarta;
    private Integer cantidad;
    private Double precio;

    public DetalleDTO() {
    }

    public DetalleDTO(Long idDetalle, Long idVenta, Long idCarta, Integer cantidad, Double precio) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idCarta = idCarta;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Long idCarta) {
        this.idCarta = idCarta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DetalleVentaDTO{" +
                "idDetalle=" + idDetalle +
                ", idVenta=" + idVenta +
                ", idCarta=" + idCarta +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
