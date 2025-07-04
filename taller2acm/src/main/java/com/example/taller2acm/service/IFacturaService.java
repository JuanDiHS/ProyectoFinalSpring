package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.FacturaEntity;

public interface IFacturaService extends BaseService<FacturaEntity>{
    List<FacturaEntity> findAll();
    Optional<FacturaEntity> findById(Long id);
    List<FacturaEntity> findByReservaId(Long reservaId);
    FacturaEntity save(FacturaEntity factura);
    void deleteById(Long id);
}