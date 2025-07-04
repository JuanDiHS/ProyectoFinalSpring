package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.EmpleadoEntity;
import com.example.taller2acm.persistence.repository.EmpleadoJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private EmpleadoJpaRepository repo;

    @Override
    public List<EmpleadoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<EmpleadoEntity> findById(Long id) {
        return repo.findById(id);
    }
    @Override
    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return repo.save(empleado);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }


    @Override
    public EmpleadoEntity update(EmpleadoEntity entity) {
        Long id = entity.getId();
        if (id == null || !repo.existsById(id)) {
            throw new ResourceNotFoundException("Empleado con id " + id + " no encontrado");
        }
        // Reutiliza save para el update
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
            throw new ResourceNotFoundException("Empleado con id " + id + " no encontrado");
        }
        repo.deleteById(idLong);
    }

    @Override
    public EmpleadoEntity findById(String id) {
         Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repo.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("Empleado con id " + id + " no encontrado"));
    }
}
