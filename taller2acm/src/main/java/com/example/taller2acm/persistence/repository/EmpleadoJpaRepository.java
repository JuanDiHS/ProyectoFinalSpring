
package com.example.taller2acm.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taller2acm.persistence.entity.EmpleadoEntity;
import com.example.taller2acm.persistence.entity.ReservaEntity;


@Repository
public interface EmpleadoJpaRepository extends JpaRepository<EmpleadoEntity, Long> {
    Optional<ReservaEntity> findByEmail(String email);
}
