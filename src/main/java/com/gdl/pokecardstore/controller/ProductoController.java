package com.gdl.pokecardstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdl.pokecardstore.dto.ProductoDTO;
import com.gdl.pokecardstore.service.IProductoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/Producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

       
    @GetMapping("/")
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }
}
