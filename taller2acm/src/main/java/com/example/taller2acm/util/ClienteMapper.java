package com.example.taller2acm.util;

import com.example.taller2acm.dto.ClienteDTO;
import com.example.taller2acm.model.Cliente;
import com.example.taller2acm.persistence.entity.ClienteEntity;

public class ClienteMapper {
    public static Cliente modelFromEntity(ClienteEntity e) {
        if (e == null) return null;
        return Cliente.builder()
                .id(e.getId())
                .primerNombre(e.getPrimerNombre())
                .segundoNombre(e.getSegundoNombre())
                .primerApellido(e.getPrimerApellido())
                .segundoApellido(e.getSegundoApellido())
                .cedula(e.getCedula())
                .direccion(e.getDireccion())
                .build();
    }

    public static ClienteEntity entityFromModel(Cliente m) {
        if (m == null) return null;
        ClienteEntity e = new ClienteEntity();
        e.setId(m.getId());
        e.setPrimerNombre(m.getPrimerNombre());
        e.setSegundoNombre(m.getSegundoNombre());
        e.setPrimerApellido(m.getPrimerApellido());
        e.setSegundoApellido(m.getSegundoApellido());
        e.setCedula(m.getCedula());
        e.setDireccion(m.getDireccion());
        return e;
    }

    public static Cliente modelFromDto(ClienteDTO dto) {
        if (dto == null) return null;
        return Cliente.builder()
                .id(dto.getId())
                .primerNombre(dto.getPrimerNombre())
                .segundoNombre(dto.getSegundoNombre())
                .primerApellido(dto.getPrimerApellido())
                .segundoApellido(dto.getSegundoApellido())
                .cedula(dto.getCedula())
                .direccion(dto.getDireccion())
                .build();
    }

    public static ClienteDTO dtoFromModel(Cliente m) {
        if (m == null) return null;
        return ClienteDTO.builder()
                .id(m.getId())
                .primerNombre(m.getPrimerNombre())
                .segundoNombre(m.getSegundoNombre())
                .primerApellido(m.getPrimerApellido())
                .segundoApellido(m.getSegundoApellido())
                .cedula(m.getCedula())
                .direccion(m.getDireccion())
                .build();
    }
}