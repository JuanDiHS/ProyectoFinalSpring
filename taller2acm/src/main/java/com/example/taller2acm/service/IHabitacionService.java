package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.HabitacionEntity;

public interface IHabitacionService extends BaseService<HabitacionEntity>{
    List<HabitacionEntity> findAll();
    Optional<HabitacionEntity> findById(Long id);
    Optional<HabitacionEntity> findByNumeroHabitacion(Integer numeroHabitacion);
    HabitacionEntity save(HabitacionEntity habitacion);
    void deleteById(Long id);
}