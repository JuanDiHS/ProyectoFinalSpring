package com.example.taller2acm.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.ReservaEntity;

@Repository
public interface ReservaJpaRepository extends JpaRepository<ReservaEntity, Long>{

    List<ReservaEntity> findByClienteId(Long clienteId);

}
