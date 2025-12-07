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

@Service // Indica que esta clase es un servicio de lógica de negocio de Spring
public class VentaServiceImpl implements VentaService {

    @Autowired // Inyección automática del repositorio de ventas
    private VentaRepository ventaRepository;

    @Autowired // Inyección automática del repositorio de usuarios
    private UsuarioRepository usuarioRepository;

    @Override
    public List<VentaDTO> obtenerVentas() {
        return ventaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void eliminarVenta(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }


    @Override
    public VentaDTO obtenerVentaPorId(Long id) {
        // Busca una venta por ID
        // Si existe, la convierte a DTO
        // Si no existe, devuelve null
        return ventaRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {
        // Busca el usuario asociado a la venta usando el ID dentro del DTO
        // Si no lo encuentra, lanza un error
        UsuarioEntity usuario = usuarioRepository.findById(ventaDTO.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Crea una nueva entidad Venta
        VentaEntity venta = new VentaEntity();

        // Asocia el usuario encontrado
        venta.setUsuario(usuario);

        // Asigna el total enviado desde el DTO
        venta.setTotal(ventaDTO.getTotal());

        // Registra la fecha y hora actual como fecha de creación
        venta.setFechaCreacion(LocalDateTime.now());

        // Guarda la venta en la base de datos
        VentaEntity nuevaVenta = ventaRepository.save(venta);

        // Devuelve la venta guardada convertida a DTO
        return convertToDTO(nuevaVenta);
    }

    // Método privado que convierte una entidad VentaEntity en un DTO VentaDTO
    private VentaDTO convertToDTO(VentaEntity v) {
        return new VentaDTO(
                v.getIdVenta(),
                v.getUsuario().getIdUsuario(),
                v.getTotal(),
                v.getFechaCreacion()
        );
    }

}
