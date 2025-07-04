package com.example.taller2acm.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.HabitacionEntity;

@Repository
public interface HabitacionJpaRepository extends JpaRepository<HabitacionEntity, Long> {
    Optional<HabitacionEntity> findByNumeroHabitacion(Integer reservaId);
}

