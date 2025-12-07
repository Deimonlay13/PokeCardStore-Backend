package com.gdl.pokecardstore.dto;

public class LoginResponse {
    private Long id;
    private String token;
    private String nombre;
    private String apellido;
    private String email;

    public LoginResponse(String token, Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.token = token;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public LoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
