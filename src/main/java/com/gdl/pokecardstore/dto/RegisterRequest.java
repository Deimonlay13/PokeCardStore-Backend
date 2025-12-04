package com.gdl.pokecardstore.dto;

public class RegisterRequest {
    private String email;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String rut;


    public RegisterRequest(String email, String contraseña, String nombre, String apellido, String rut) {
        this.email = email;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }

}
