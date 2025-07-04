package com.example.taller2acm.util;

import com.example.taller2acm.dto.FacturaDTO;
import com.example.taller2acm.model.Factura;
import com.example.taller2acm.persistence.entity.FacturaEntity;
import com.example.taller2acm.persistence.entity.PagoEntity;
import com.example.taller2acm.persistence.entity.ReservaEntity;

public class FacturaMapper {
    public static Factura modelFromEntity(FacturaEntity e) {
        if (e == null) return null;
        return Factura.builder()
                .id(e.getId())
                .fechaEmision(e.getFechaEmision())
                .valorTotal(e.getValorTotal())
                .reservaId(e.getReserva().getId())
                .pagoId(e.getPago().getId())
                .build();
    }

    public static FacturaEntity entityFromModel(Factura m) {
        if (m == null) return null;
        FacturaEntity e = new FacturaEntity();
        e.setId(m.getId());
        e.setFechaEmision(m.getFechaEmision());
        e.setValorTotal(m.getValorTotal());
        ReservaEntity re = new ReservaEntity(); re.setId(m.getReservaId());
        PagoEntity pe = new PagoEntity(); pe.setId(m.getPagoId());
        e.setReserva(re);
        e.setPago(pe);
        return e;
    }

    public static Factura modelFromDto(FacturaDTO dto) {
        if (dto == null) return null;
        return Factura.builder()
                .id(dto.getId())
                .fechaEmision(dto.getFechaEmision())
                .valorTotal(dto.getValorTotal())
                .reservaId(dto.getReservaId())
                .pagoId(dto.getPagoId())
                .build();
    }

    public static FacturaDTO dtoFromModel(Factura m) {
        if (m == null) return null;
        return FacturaDTO.builder()
                .id(m.getId())
                .fechaEmision(m.getFechaEmision())
                .valorTotal(m.getValorTotal())
                .reservaId(m.getReservaId())
                .pagoId(m.getPagoId())
                .build();
    }
}