package com.example.taller2acm.util;

import com.example.taller2acm.dto.AdminGeneralDTO;
import com.example.taller2acm.model.AdminGeneral;
import com.example.taller2acm.persistence.entity.AdminGeneralEntity;

public class AdminGeneralMapper {
    public static AdminGeneral modelFromEntity(AdminGeneralEntity e) {
        if (e == null) return null;
        return AdminGeneral.builder()
                .id(e.getId())
                .correo(e.getCorreo())
                .telefono(e.getTelefono())
                .primerNombre(e.getPrimerNombre())
                .segundoNombre(e.getSegundoNombre())
                .primerApellido(e.getPrimerApellido())
                .segundoApellido(e.getSegundoApellido())
                .build();
    }

    public static AdminGeneralEntity entityFromModel(AdminGeneral m) {
        if (m == null) return null;
        AdminGeneralEntity e = new AdminGeneralEntity();
        e.setId(m.getId());
        e.setCorreo(m.getCorreo());
        e.setTelefono(m.getTelefono());
        e.setPrimerNombre(m.getPrimerNombre());
        e.setSegundoNombre(m.getSegundoNombre());
        e.setPrimerApellido(m.getPrimerApellido());
        e.setSegundoApellido(m.getSegundoApellido());
        return e;
    }

    public static AdminGeneral modelFromDto(AdminGeneralDTO dto) {
        if (dto == null) return null;
        return AdminGeneral.builder()
                .id(dto.getId())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .primerNombre(dto.getPrimerNombre())
                .segundoNombre(dto.getSegundoNombre())
                .primerApellido(dto.getPrimerApellido())
                .segundoApellido(dto.getSegundoApellido())
                .build();
    }

    public static AdminGeneralDTO dtoFromModel(AdminGeneral m) {
        if (m == null) return null;
        return AdminGeneralDTO.builder()
                .id(m.getId())
                .correo(m.getCorreo())
                .telefono(m.getTelefono())
                .primerNombre(m.getPrimerNombre())
                .segundoNombre(m.getSegundoNombre())
                .primerApellido(m.getPrimerApellido())
                .segundoApellido(m.getSegundoApellido())
                .build();
    }
}