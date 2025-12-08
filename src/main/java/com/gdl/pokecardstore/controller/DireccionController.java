package com.gdl.pokecardstore.controller;

import com.gdl.pokecardstore.entity.DireccionEntity;
import com.gdl.pokecardstore.service.IDireccionService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direccion")
@CrossOrigin(origins = "*")
public class DireccionController {

    private final IDireccionService direccionService;

    public DireccionController(IDireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping("/usuario/{idUsuario}")
    public DireccionEntity agregarDireccion(
            @PathVariable Long idUsuario,
            @RequestBody DireccionEntity direccion) {

        return direccionService.agregarDireccion(idUsuario, direccion);
    }

    @GetMapping("/usuario/{idUsuario}")
    public DireccionEntity obtenerDireccion(@PathVariable Long idUsuario) {
        return direccionService.obtenerDireccion(idUsuario);
    }
}
