package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.PagoEntity;
import com.example.taller2acm.persistence.repository.PagoJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private PagoJpaRepository repo;

    @Override
    public List<PagoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<PagoEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<PagoEntity> findByReservaId(Long reservaId) {
        return repo.findByReservaId(reservaId);
    }


    @Override
    public PagoEntity save(PagoEntity pago) {
        return repo.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        if (!repo.existsById(idLong)) {
            throw new ResourceNotFoundException("Pago con id " + id + " no encontrado");
        }
        repo.deleteById(idLong);
    }

    @Override
    public PagoEntity findById(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repo.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("Pago con id " + id + " no encontrado"));
    }

    @Override
    public PagoEntity update(PagoEntity entity) {
        Long id = entity.getId();
        if (id == null || !repo.existsById(id)) {
            throw new ResourceNotFoundException("Pago con id " + id + " no encontrado");
        }
        // Guarda cambios
        return repo.save(entity);
    }

}