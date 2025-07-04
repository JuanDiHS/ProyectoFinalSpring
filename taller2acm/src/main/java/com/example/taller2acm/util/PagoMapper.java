package com.example.taller2acm.util;

import com.example.taller2acm.dto.PagoDTO;
import com.example.taller2acm.model.Pago;
import com.example.taller2acm.persistence.entity.PagoEntity;
import com.example.taller2acm.persistence.entity.ReservaEntity;

public class PagoMapper {
    public static Pago modelFromEntity(PagoEntity e) {
        if (e == null) return null;
        return Pago.builder()
                .id(e.getId())
                .fecha(e.getFecha())
                .metodoPago(e.getMetodoPago())
                .pagoTotal(e.getPagoTotal())
                .reservaId(e.getReserva().getId())
                .build();
    }

    public static PagoEntity entityFromModel(Pago m) {
        if (m == null) return null;
        PagoEntity e = new PagoEntity();
        e.setId(m.getId());
        e.setFecha(m.getFecha());
        e.setMetodoPago(m.getMetodoPago());
        e.setPagoTotal(m.getPagoTotal());
        ReservaEntity re = new ReservaEntity(); re.setId(m.getReservaId());
        e.setReserva(re);
        return e;
    }

    public static Pago modelFromDto(PagoDTO dto) {
        if (dto == null) return null;
        return Pago.builder()
                .id(dto.getId())
                .fecha(dto.getFecha())
                .metodoPago(dto.getMetodoPago())
                .pagoTotal(dto.getPagoTotal())
                .reservaId(dto.getReservaId())
                .build();
    }

    public static PagoDTO dtoFromModel(Pago m) {
        if (m == null) return null;
        return PagoDTO.builder()
                .id(m.getId())
                .fecha(m.getFecha())
                .metodoPago(m.getMetodoPago())
                .pagoTotal(m.getPagoTotal())
                .reservaId(m.getReservaId())
                .build();
    }
}