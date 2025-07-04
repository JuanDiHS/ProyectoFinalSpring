package com.example.taller2acm.service;
import java.util.List;
import java.util.Optional;

import com.example.taller2acm.persistence.entity.HotelEntity;

public interface IHotelService extends BaseService<HotelEntity>{
    List<HotelEntity> findAll();
    Optional<HotelEntity> findById(Long id);
    Optional<HotelEntity> findByNombre(String nombre);
    HotelEntity save(HotelEntity hotel);
    void deleteById(Long id);
}