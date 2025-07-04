package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.taller2acm.persistence.entity.AdminGeneralEntity;
import com.example.taller2acm.persistence.repository.AdminGeneralJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class AdminGeneralServiceImpl implements IAdminGeneralService {

    private final AdminGeneralJpaRepository repository;

    @Override
    public AdminGeneralEntity save(AdminGeneralEntity admin) {
        return repository.save(admin);
    }



     @Override
    public List<AdminGeneralEntity> findAll() {
        return repository.findAll();
    }


     @Override
    public Optional<AdminGeneralEntity> findById(Long id) {
        return repository.findById(id);
    }

   @Override
    public Optional<AdminGeneralEntity> findByCorreo(String correo) {
        return repository.findByCorreo(correo);
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AdminGeneralEntity update(AdminGeneralEntity entity) {
        if (entity.getId() == null || !repository.existsById(entity.getId())) {
            throw new ResourceNotFoundException(
                "AdministradorGeneral con id " + entity.getId() + " no encontrado"
            );
        }
        // Reutiliza save para el update
        return repository.save(entity);
    }


    @Override
    public void delete(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        if (!repository.existsById(idLong)) {
            throw new ResourceNotFoundException("AdministradorGeneral con id " + id + " no encontrado");
        }
        repository.deleteById(idLong);
    }

    @Override
    public AdminGeneralEntity findById(String id) {
        Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repository.findById(idLong)
           .orElseThrow(() -> new ResourceNotFoundException(
                "AdministradorGeneral con id " + id + " no encontrado"
            ));
    }
    }

   

