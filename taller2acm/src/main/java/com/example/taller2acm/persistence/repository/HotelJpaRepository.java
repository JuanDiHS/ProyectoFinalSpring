package com.example.taller2acm.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.HotelEntity;

@Repository
public interface HotelJpaRepository extends JpaRepository<HotelEntity, Long> {
    Optional<HotelEntity> findByNombre(String nombre);
}
