package com.gdl.pokecardstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
@Table(name = "direccion")
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long idDireccion;

    @NotBlank(message = "La región es obligatoria")
    @Column(nullable = false)
    private String region;

    @NotBlank(message = "La comuna es obligatoria")
    @Column(nullable = false)
    private String comuna;

    @NotBlank(message = "La calle es obligatoria")
    @Column(nullable = false)
    private String calle;

    @Positive(message = "El número debe ser positivo")
    @Column(nullable = true)
    private Integer numero;

    @Column(name = "fecha_alta", nullable = false, updatable = false)
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @PrePersist
    protected void onCreate() {
        fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaModificacion = LocalDateTime.now();
    }

    public DireccionEntity(Long idDireccion, String region, String comuna, String calle, Integer numero) {
        this.idDireccion = idDireccion;
        this.region = region;
        this.comuna = comuna;
        this.calle = calle;
        this.numero = numero;
    }

    public DireccionEntity() {
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "DireccionEntity{" +
                "idDireccion=" + idDireccion +
                ", region='" + region + '\'' +
                ", comuna='" + comuna + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}
