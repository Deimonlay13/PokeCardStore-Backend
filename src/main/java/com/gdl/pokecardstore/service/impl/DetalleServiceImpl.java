package com.gdl.pokecardstore.service.impl;

import com.gdl.pokecardstore.dto.DetalleDTO;
import com.gdl.pokecardstore.entity.DetalleEntity;
import com.gdl.pokecardstore.entity.VentaEntity;
import com.gdl.pokecardstore.repository.IDetalleRepository;
import com.gdl.pokecardstore.service.IDetalleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleServiceImpl implements IDetalleService {

    private final IDetalleRepository detalleRepository;

    public DetalleServiceImpl(IDetalleRepository detalleRepository) {
        this.detalleRepository = detalleRepository;
    }

    @Override
    public DetalleDTO createDetalle(DetalleDTO detalleDTO) {
        VentaEntity venta = new VentaEntity();
        venta.setIdVenta(detalleDTO.getIdVenta()); // solo referencia

        DetalleEntity entity = new DetalleEntity();
        entity.setVenta(venta);
        entity.setIdCarta(detalleDTO.getIdCarta());
        entity.setCantidad(detalleDTO.getCantidad());
        entity.setPrecio(detalleDTO.getPrecio());

        DetalleEntity saved = detalleRepository.save(entity);
        detalleDTO.setIdDetalle(saved.getIdDetalle());
        return detalleDTO;
    }

    @Override
    public List<DetalleDTO> getDetallesByVenta(Long idVenta) {
        VentaEntity venta = new VentaEntity();
        venta.setIdVenta(idVenta);

        return detalleRepository.findByVenta(venta)
                .stream()
                .map(entity -> new DetalleDTO(
                        entity.getIdDetalle(),
                        entity.getVenta().getIdVenta(),
                        entity.getIdCarta(),
                        entity.getCantidad(),
                        entity.getPrecio()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DetalleDTO> getDetallesByUsuario(Long idUsuario) {
        return detalleRepository.findByVenta_Usuario_IdUsuario(idUsuario)
                .stream()
                .map(entity -> new DetalleDTO(
                        entity.getIdDetalle(),
                        entity.getVenta().getIdVenta(),
                        entity.getIdCarta(),
                        entity.getCantidad(),
                        entity.getPrecio()))
                .collect(Collectors.toList());
    }
}
