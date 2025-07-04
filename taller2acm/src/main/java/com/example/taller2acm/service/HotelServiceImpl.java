package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taller2acm.exception.ResourceNotFoundException;
import com.example.taller2acm.persistence.entity.HotelEntity;
import com.example.taller2acm.persistence.repository.HotelJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private HotelJpaRepository repo;

    @Override
    public List<HotelEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<HotelEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<HotelEntity> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    @Override
    public HotelEntity save(HotelEntity hotel) {
        return repo.save(hotel);
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
            throw new ResourceNotFoundException("Hotel con id " + id + " no encontrado");
        }
        repo.deleteById(idLong);
    }

    @Override
    public HotelEntity findById(String id) {
         Long idLong;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El id debe ser numérico: " + id);
        }
        return repo.findById(idLong)
            .orElseThrow(() -> new ResourceNotFoundException("Hotel con id " + id + " no encontrado"));
    }

    @Override
    public HotelEntity update(HotelEntity entity) {
        Long id = entity.getId();
        if (id == null || !repo.existsById(id)) {
            throw new ResourceNotFoundException("Hotel con id " + id + " no encontrado");
        }
        // Guarda cambios
        return repo.save(entity);
    }

}