package com.gdl.pokecardstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdl.pokecardstore.entity.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
}
