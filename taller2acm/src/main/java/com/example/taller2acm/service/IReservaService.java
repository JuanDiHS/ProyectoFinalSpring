package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.ReservaEntity;

public interface IReservaService extends BaseService<ReservaEntity>{

     List<ReservaEntity> findAll();
    Optional<ReservaEntity> findById(Long id);
    List<ReservaEntity> findByClienteId(Long clienteId);
    ReservaEntity save(ReservaEntity reserva);
    void deleteById(Long id);

}
