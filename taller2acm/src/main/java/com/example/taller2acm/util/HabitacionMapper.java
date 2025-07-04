package com.example.taller2acm.util;

import com.example.taller2acm.dto.HabitacionDTO;
import com.example.taller2acm.model.Habitacion;
import com.example.taller2acm.persistence.entity.HabitacionEntity;
import com.example.taller2acm.persistence.entity.HotelEntity;
import com.example.taller2acm.persistence.entity.TipoHabitacionEntity;

public class HabitacionMapper {
    public static Habitacion modelFromEntity(HabitacionEntity e) {
        if (e == null) return null;
        return Habitacion.builder()
                .id(e.getId())
                .numeroHabitacion(e.getNumeroHabitacion())
                .precioDia(e.getPrecioDia())
                .disponible(e.getDisponible())
                .hotelId(e.getHotel().getId())
                .tipoHabitacionId(e.getTipoHabitacion().getId())
                .build();
    }

    public static HabitacionEntity entityFromModel(Habitacion m) {
        if (m == null) return null;
        HabitacionEntity e = new HabitacionEntity();
        e.setId(m.getId());
        e.setNumeroHabitacion(m.getNumeroHabitacion());
        e.setPrecioDia(m.getPrecioDia());
        e.setDisponible(m.getDisponible());
        HotelEntity he = new HotelEntity(); he.setId(m.getHotelId());
        TipoHabitacionEntity te = new TipoHabitacionEntity(); te.setId(m.getTipoHabitacionId());
        e.setHotel(he);
        e.setTipoHabitacion(te);
        return e;
    }

    public static Habitacion modelFromDto(HabitacionDTO dto) {
        if (dto == null) return null;
        return Habitacion.builder()
                .id(dto.getId())
                .numeroHabitacion(dto.getNumeroHabitacion())
                .precioDia(dto.getPrecioDia())
                .disponible(dto.getDisponible())
                .hotelId(dto.getHotelId())
                .tipoHabitacionId(dto.getTipoHabitacionId())
                .build();
    }

    public static HabitacionDTO dtoFromModel(Habitacion m) {
        if (m == null) return null;
        return HabitacionDTO.builder()
                .id(m.getId())
                .numeroHabitacion(m.getNumeroHabitacion())
                .precioDia(m.getPrecioDia())
                .disponible(m.getDisponible())
                .hotelId(m.getHotelId())
                .tipoHabitacionId(m.getTipoHabitacionId())
                .build();
    }
}
