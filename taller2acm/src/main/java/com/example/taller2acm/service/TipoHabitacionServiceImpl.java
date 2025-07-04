package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.TipoHabitacionEntity;
import com.example.taller2acm.persistence.repository.TipoHabitacionJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class TipoHabitacionServiceImpl implements ITipoHabitacionService {

    @Autowired
    private TipoHabitacionJpaRepository repo;

    @Override
    public List<TipoHabitacionEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoHabitacionEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<TipoHabitacionEntity> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }


    @Override
    public TipoHabitacionEntity save(TipoHabitacionEntity tipo) {
        return repo.save(tipo);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public TipoHabitacionEntity update(TipoHabitacionEntity entity) {
         Long id = entity.getId();
        if (id == null || !repo.existsById(id)) {
            throw new ResourceNotFoundException("TipoHabitacion con id " + id + " no encontrado");
        }
        // Guarda los cambios
        return repo.save(entity);
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
            throw new ResourceNotFoundException("TipoHabitacion con id " + id + " no encontrado");
        }
        repo.deleteById(idLong);
    }

    @Override
    public TipoHabitacionEntity findById(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repo.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("TipoHabitacion con id " + id + " no encontrado"));
    }
    }

   

