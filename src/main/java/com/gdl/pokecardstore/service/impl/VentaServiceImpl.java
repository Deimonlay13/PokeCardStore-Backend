package com.gdl.pokecardstore.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdl.pokecardstore.dto.VentaDTO;
import com.gdl.pokecardstore.entity.UsuarioEntity;
import com.gdl.pokecardstore.entity.VentaEntity;
import com.gdl.pokecardstore.repository.UsuarioRepository;
import com.gdl.pokecardstore.repository.VentaRepository;
import com.gdl.pokecardstore.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR TODAS
    @Override
    public List<VentaDTO> obtenerVentas() {
        return ventaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ELIMINAR
    @Override
    public void eliminarVenta(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }

    // OBTENER POR ID
    @Override
    public VentaDTO obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // CREAR VENTA
    @Override
    public VentaDTO crearVenta(VentaDTO dto) {

        UsuarioEntity usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        VentaEntity venta = new VentaEntity();
        venta.setUsuario(usuario);
        venta.setTotal(dto.getTotal());
        venta.setFechaCreacion(LocalDateTime.now());

        VentaEntity nuevaVenta = ventaRepository.save(venta);

        return convertToDTO(nuevaVenta);
    }

    // CONVERTIR ENTITY A DTO
    private VentaDTO convertToDTO(VentaEntity v) {

        return new VentaDTO(
                v.getIdVenta(),
                v.getUsuario().getIdCliente(),
                v.getTotal(),
                v.getFechaCreacion()
        );
    }
}
