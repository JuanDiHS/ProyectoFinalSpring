package com.example.taller2acm.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.taller2acm.persistence.entity.PagoEntity;

@Repository
public interface PagoJpaRepository extends JpaRepository<PagoEntity, Long> {
    List<PagoEntity> findByReservaId(Long reservaId);
}
