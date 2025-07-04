package com.example.taller2acm.util;

import com.example.taller2acm.dto.TipoHabitacionDTO;
import com.example.taller2acm.model.TipoHabitacion;
import com.example.taller2acm.persistence.entity.HotelEntity;
import com.example.taller2acm.persistence.entity.TipoHabitacionEntity;

public class TipoHabitacionMapper {
    public static TipoHabitacion modelFromEntity(TipoHabitacionEntity e) {
        if (e == null) return null;
        return TipoHabitacion.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .cantidad(e.getCantidad())
                .hotelId(e.getHotel().getId())
                .build();
    }

    public static TipoHabitacionEntity entityFromModel(TipoHabitacion m) {
        if (m == null) return null;
        TipoHabitacionEntity e = new TipoHabitacionEntity();
        e.setId(m.getId());
        e.setNombre(m.getNombre());
        e.setCantidad(m.getCantidad());
        HotelEntity he = new HotelEntity(); he.setId(m.getHotelId());
        e.setHotel(he);
        return e;
    }

    public static TipoHabitacion modelFromDto(TipoHabitacionDTO dto) {
        if (dto == null) return null;
        return TipoHabitacion.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .cantidad(dto.getCantidad())
                .hotelId(dto.getHotelId())
                .build();
    }

    public static TipoHabitacionDTO dtoFromModel(TipoHabitacion m) {
        if (m == null) return null;
        return TipoHabitacionDTO.builder()
                .id(m.getId())
                .nombre(m.getNombre())
                .cantidad(m.getCantidad())
                .hotelId(m.getHotelId())
                .build();
    }
}