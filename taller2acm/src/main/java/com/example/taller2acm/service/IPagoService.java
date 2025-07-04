package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.PagoEntity;

public interface IPagoService extends BaseService<PagoEntity>{
    List<PagoEntity> findAll();
    Optional<PagoEntity> findById(Long id);
    List<PagoEntity> findByReservaId(Long reservaId);
    PagoEntity save(PagoEntity pago);
    void deleteById(Long id);
}