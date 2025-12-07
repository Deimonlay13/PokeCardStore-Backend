package com.gdl.pokecardstore.controller;

import com.gdl.pokecardstore.dto.*;
import com.gdl.pokecardstore.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        usuarioService.register(request);
        return "Usuario registrado con éxito";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return usuarioService.login(request);
    }
}
