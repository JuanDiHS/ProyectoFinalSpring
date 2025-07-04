package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.FacturaEntity;
import com.example.taller2acm.persistence.repository.FacturaJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    private FacturaJpaRepository repo;

    @Override
    public List<FacturaEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<FacturaEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<FacturaEntity> findByReservaId(Long reservaId) {
        return repo.findByReservaId(reservaId);
    }


    @Override
    public FacturaEntity save(FacturaEntity factura) {
        return repo.save(factura);
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
            throw new ResourceNotFoundException("Factura con id " + id + " no encontrada");
        }
        repo.deleteById(idLong);
    }

    @Override
    public FacturaEntity findById(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repo.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("Factura con id " + id + " no encontrada"));
    }

    @Override
    public FacturaEntity update(FacturaEntity entity) {
         Long id = entity.getId();
        if (id == null || !repo.existsById(id)) {
            throw new ResourceNotFoundException("Factura con id " + id + " no encontrada");
        }
        // Guardar cambios
        return repo.save(entity);
    }


}