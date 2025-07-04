package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.HabitacionEntity;
import com.example.taller2acm.persistence.repository.HabitacionJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class HabitacionServiceImpl implements IHabitacionService {

    @Autowired
    private HabitacionJpaRepository repo;

    @Override
    public List<HabitacionEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<HabitacionEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<HabitacionEntity> findByNumeroHabitacion(Integer numeroHabitacion) {
        return repo.findByNumeroHabitacion(numeroHabitacion);
    }

    @Override
    public HabitacionEntity save(HabitacionEntity habitacion) {
        return repo.save(habitacion);
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
            throw new ResourceNotFoundException("Habitación con id " + id + " no encontrada");
        }
        repo.deleteById(idLong);
    }

    @Override
    public HabitacionEntity findById(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repo.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("Habitación con id " + id + " no encontrada"));
    }

    @Override
    public HabitacionEntity update(HabitacionEntity entity) {
      Long id = entity.getId();
        if (id == null || !repo.existsById(id)) {
            throw new ResourceNotFoundException("Habitación con id " + id + " no encontrada");
        }
        // Guarda los cambios
        return repo.save(entity);
    }

}