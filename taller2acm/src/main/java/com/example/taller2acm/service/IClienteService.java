package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.ClienteEntity;

public interface IClienteService extends BaseService<ClienteEntity>{
    List<ClienteEntity> findAll();
    Optional<ClienteEntity> findById(Long id);
    ClienteEntity save(ClienteEntity cliente);
    void deleteById(Long id);
}