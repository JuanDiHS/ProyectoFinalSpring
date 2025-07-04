package com.example.taller2acm.util;

import com.example.taller2acm.dto.EmpleadoDTO;
import com.example.taller2acm.model.Empleado;
import com.example.taller2acm.persistence.entity.EmpleadoEntity;

public class EmpleadoMapper {
    public static Empleado modelFromEntity(EmpleadoEntity e) {
        if (e == null) return null;
        return Empleado.builder()
                .id(e.getId())
                .correo(e.getEmail())
                .telefono(e.getTelefono())
                .primerNombre(e.getPrimerNombre())
                .segundoNombre(e.getSegundoNombre())
                .primerApellido(e.getPrimerApellido())
                .segundoApellido(e.getSegundoApellido())
                .build();
    }

    public static EmpleadoEntity entityFromModel(Empleado m) {
        if (m == null) return null;
        EmpleadoEntity e = new EmpleadoEntity();
        e.setId(m.getId());
        e.setEmail(m.getCorreo());
        e.setTelefono(m.getTelefono());
        e.setPrimerNombre(m.getPrimerNombre());
        e.setSegundoNombre(m.getSegundoNombre());
        e.setPrimerApellido(m.getPrimerApellido());
        e.setSegundoApellido(m.getSegundoApellido());
        return e;
    }

    public static Empleado modelFromDto(EmpleadoDTO dto) {
        if (dto == null) return null;
        return Empleado.builder()
                .id(dto.getId())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .primerNombre(dto.getPrimerNombre())
                .segundoNombre(dto.getSegundoNombre())
                .primerApellido(dto.getPrimerApellido())
                .segundoApellido(dto.getSegundoApellido())
                .build();
    }

    public static EmpleadoDTO dtoFromModel(Empleado m) {
        if (m == null) return null;
        return EmpleadoDTO.builder()
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
