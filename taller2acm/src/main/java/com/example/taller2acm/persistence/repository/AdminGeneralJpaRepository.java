package com.example.taller2acm.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.AdminGeneralEntity;

@Repository
public interface AdminGeneralJpaRepository extends JpaRepository<AdminGeneralEntity, Long> {
    Optional<AdminGeneralEntity> findByCorreo(String correo);
   
}
