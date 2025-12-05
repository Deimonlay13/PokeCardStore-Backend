package com.gdl.pokecardstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdl.pokecardstore.dto.VentaDTO;
import com.gdl.pokecardstore.service.VentaService;

@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService ventaService;


    @GetMapping("/{id}")
    public VentaDTO obtenerVentaPorId(@PathVariable Long id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @PostMapping
    public VentaDTO crearVenta(@RequestBody VentaDTO ventaDTO) {
        return ventaService.crearVenta(ventaDTO);
    }
}
