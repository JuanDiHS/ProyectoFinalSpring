package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.ReservaEntity;
import com.example.taller2acm.persistence.repository.ReservaJpaRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ReservaServiceImpl implements IReservaService {

    private final ReservaJpaRepository repository;

    @Override
    public List<ReservaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ReservaEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ReservaEntity save(ReservaEntity reserva) {
        return repository.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ReservaEntity update(ReservaEntity reserva) {
        Long id = reserva.getId();
        if (id == null || !repository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva con id " + id + " no encontrada");
        }
        return repository.save(reserva);
    }

    @Override
    public List<ReservaEntity> findByClienteId(Long clienteId) {
        return repository.findByClienteId(clienteId);
    }

    @Override
    public void delete(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        if (!repository.existsById(idLong)) {
            throw new ResourceNotFoundException("Reserva con id " + id + " no encontrada");
        }
        repository.deleteById(idLong);
    }

    @Override
    public ReservaEntity findById(String id) {
       Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repository.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("Reserva con id " + id + " no encontrada"));
    }



}
