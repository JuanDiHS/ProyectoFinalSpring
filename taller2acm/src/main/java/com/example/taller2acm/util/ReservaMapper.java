package com.example.taller2acm.util;

import com.example.taller2acm.dto.ReservaDTO;
import com.example.taller2acm.model.Reserva;
import com.example.taller2acm.persistence.entity.ClienteEntity;
import com.example.taller2acm.persistence.entity.HabitacionEntity;
import com.example.taller2acm.persistence.entity.ReservaEntity;

public class ReservaMapper {
    public static Reserva modelFromEntity(ReservaEntity e) {
        if (e == null) return null;
        return Reserva.builder()
                .id(e.getId())
                .fechaInicio(e.getFechaInicio())
                .fechaFinal(e.getFechaFinal())
                .cantidadDias(e.getCantidadDias())
                .estado(e.getEstado())
                .fechaReserva(e.getFechaReserva())
                .clienteId(e.getCliente().getId())
                .habitacionId(e.getHabitacion().getId())
                .build();
    }

    public static ReservaEntity entityFromModel(Reserva m) {
        if (m == null) return null;
        ReservaEntity e = new ReservaEntity();
        e.setId(m.getId());
        e.setFechaInicio(m.getFechaInicio());
        e.setFechaFinal(m.getFechaFinal());
        e.setCantidadDias(m.getCantidadDias());
        e.setEstado(m.getEstado());
        e.setFechaReserva(m.getFechaReserva());
        ClienteEntity ce = new ClienteEntity(); ce.setId(m.getClienteId());
        HabitacionEntity he = new HabitacionEntity(); he.setId(m.getHabitacionId());
        e.setCliente(ce);
        e.setHabitacion(he);
        return e;
    }

    public static Reserva modelFromDto(ReservaDTO dto) {
        if (dto == null) return null;
        return Reserva.builder()
                .id(dto.getClienteId())
                .fechaInicio(dto.getFechaInicio())
                .fechaFinal(dto.getFechaFinal())
                .cantidadDias(dto.getCantidadDias())
                .estado(dto.isEstado())
                .fechaReserva(dto.getFechaReserva())
                
                .build();
    }

    public static ReservaDTO dtoFromModel(Reserva m) {
        if (m == null) return null;
        return ReservaDTO.builder()
                .clienteId(m.getId())
                .fechaInicio(m.getFechaInicio())
                .fechaFinal(m.getFechaFinal())
                .cantidadDias(m.getCantidadDias())
                .estado(m.getEstado())
                .fechaReserva(m.getFechaReserva())
                .clienteId(m.getClienteId())
                .build();
    }
}
