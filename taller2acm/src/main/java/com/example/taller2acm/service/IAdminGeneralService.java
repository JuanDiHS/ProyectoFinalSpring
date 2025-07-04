package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.AdminGeneralEntity;

public interface IAdminGeneralService extends BaseService<AdminGeneralEntity>{
    List<AdminGeneralEntity> findAll();
    Optional<AdminGeneralEntity> findById(Long id);
    Optional<AdminGeneralEntity> findByCorreo(String correo);
    AdminGeneralEntity save(AdminGeneralEntity admin);
    void deleteById(Long id);
}
