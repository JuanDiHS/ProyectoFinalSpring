package com.example.taller2acm.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.FacturaEntity;

@Repository
public interface FacturaJpaRepository extends JpaRepository<FacturaEntity, Long> {
     List<FacturaEntity> findByReservaId(Long reservaId);
}