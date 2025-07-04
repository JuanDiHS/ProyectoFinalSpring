package com.example.taller2acm.util;

import com.example.taller2acm.dto.HotelDTO;
import com.example.taller2acm.model.Hotel;
import com.example.taller2acm.persistence.entity.HotelEntity;

public class HotelMapper {
    public static Hotel modelFromEntity(HotelEntity e) {
        if (e == null) return null;
        return Hotel.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .ciudad(e.getCiudad())
                .telefono(e.getTelefono())
                .correo(e.getCorreo())
                .direccion(e.getDireccion())
                .build();
    }

    public static HotelEntity entityFromModel(Hotel m) {
        if (m == null) return null;
        HotelEntity e = new HotelEntity();
        e.setId(m.getId());
        e.setNombre(m.getNombre());
        e.setCiudad(m.getCiudad());
        e.setTelefono(m.getTelefono());
        e.setCorreo(m.getCorreo());
        e.setDireccion(m.getDireccion());
        return e;
    }

    public static Hotel modelFromDto(HotelDTO dto) {
        if (dto == null) return null;
        return Hotel.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .ciudad(dto.getCiudad())
                .telefono(dto.getTelefono())
                .correo(dto.getCorreo())
                .direccion(dto.getDireccion())
                .build();
    }

    public static HotelDTO dtoFromModel(Hotel m) {
        if (m == null) return null;
        return HotelDTO.builder()
                .id(m.getId())
                .nombre(m.getNombre())
                .ciudad(m.getCiudad())
                .telefono(m.getTelefono())
                .correo(m.getCorreo())
                .direccion(m.getDireccion())
                .build();
    }
}
