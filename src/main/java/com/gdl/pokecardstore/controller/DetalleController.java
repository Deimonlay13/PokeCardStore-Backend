package com.gdl.pokecardstore.controller;

import com.gdl.pokecardstore.dto.DetalleDTO;
import com.gdl.pokecardstore.service.IDetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/detalle-venta")
public class DetalleController {

    private final IDetalleService detalleService;

    public DetalleController(IDetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @PostMapping
    public ResponseEntity<DetalleDTO> createDetalle(@RequestBody DetalleDTO detalleDTO) {
        DetalleDTO created = detalleService.createDetalle(detalleDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<DetalleDTO>> getDetallesByVenta(@PathVariable Long idVenta) {
        List<DetalleDTO> detalles = detalleService.getDetallesByVenta(idVenta);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<DetalleDTO>> getDetallesByUsuario(@PathVariable Long idUsuario) {
        List<DetalleDTO> detalles = detalleService.getDetallesByUsuario(idUsuario);
        return ResponseEntity.ok(detalles);
    }
}
