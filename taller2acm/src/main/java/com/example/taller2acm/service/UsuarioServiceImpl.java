package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.UsuarioEntity;
import com.example.taller2acm.persistence.repository.UsuarioJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioJpaRepository repo;

    @Override
    public List<UsuarioEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return repo.findById(id);
    }


    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return repo.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity entity) {
      Long id = entity.getId();
        if (id == null || !repo.existsById(id)) {
            throw new ResourceNotFoundException("Usuario con id " + id + " no encontrado");
        }
        // Guarda cambios
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
            throw new ResourceNotFoundException("Usuario con id " + id + " no encontrado");
        }
        repo.deleteById(idLong);
    }

    @Override
    public UsuarioEntity findById(String id) {
       Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repo.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario con id " + id + " no encontrado"));
    }


}