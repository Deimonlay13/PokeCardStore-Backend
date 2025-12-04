package com.gdl.pokecardstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gdl.pokecardstore.dto.ProductoDTO;
import com.gdl.pokecardstore.repository.IProductoRepository;
import com.gdl.pokecardstore.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

    private final IProductoRepository productoRepository;

    public ProductoServiceImpl(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
       
    }

    @Override
    public List<ProductoDTO> getAllProductos() {
      return productoRepository.findAll().stream().map(producto ->{
        ProductoDTO dto= new ProductoDTO();
        dto.setId(producto.getIdProducto());
        dto.setNombre(producto.getNombre());
        dto.setImg(producto.getImg());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        return dto;
      }).collect(Collectors.toList());
    }

     

}
