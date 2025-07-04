package com.example.taller2acm.util;

import com.example.taller2acm.dto.UsuarioDTO;
import com.example.taller2acm.model.Usuario;
import com.example.taller2acm.persistence.entity.AdminGeneralEntity;
import com.example.taller2acm.persistence.entity.ClienteEntity;
import com.example.taller2acm.persistence.entity.EmpleadoEntity;
import com.example.taller2acm.persistence.entity.UsuarioEntity;

public class UsuarioMapper {
    public static Usuario modelFromEntity(UsuarioEntity e) {
        if (e == null) return null;
        return Usuario.builder()
                .id(e.getId())
                .nombreUsuario(e.getNombreUsuario())
                .contrasena(e.getContrasena())
                .rol(e.getRol())
                .clienteId(e.getCliente() != null ? e.getCliente().getId() : null)
                .empleadoId(e.getEmpleado() != null ? e.getEmpleado().getId() : null)
                .administradorGeneralId(e.getAdministradorGeneral() != null ? e.getAdministradorGeneral().getId() : null)
                .build();
    }

    public static UsuarioEntity entityFromModel(Usuario m) {
        if (m == null) return null;
        UsuarioEntity e = new UsuarioEntity();
        e.setId(m.getId());
        e.setNombreUsuario(m.getNombreUsuario());
        e.setContrasena(m.getContrasena());
        e.setRol(m.getRol());
        if (m.getClienteId() != null) { ClienteEntity ce = new ClienteEntity(); ce.setId(m.getClienteId()); e.setCliente(ce); }
        if (m.getEmpleadoId() != null) { EmpleadoEntity ee = new EmpleadoEntity(); ee.setId(m.getEmpleadoId()); e.setEmpleado(ee); }
        if (m.getAdministradorGeneralId() != null) { AdminGeneralEntity ae = new AdminGeneralEntity(); ae.setId(m.getAdministradorGeneralId()); e.setAdministradorGeneral(ae); }
        return e;
    }

    public static Usuario modelFromDto(UsuarioDTO dto) {
        if (dto == null) return null;
        return Usuario.builder()
                .id(dto.getClienteId())
                .nombreUsuario(dto.getNombreUsuario())
                .contrasena(dto.getContrasena())
                .rol(dto.getRol())
                .clienteId(dto.getClienteId())
                .build();
    }

    public static UsuarioDTO dtoFromModel(Usuario m) {
        if (m == null) return null;
        return UsuarioDTO.builder()
                .clienteId(m.getId())
                .nombreUsuario(m.getNombreUsuario())
                .contrasena(m.getContrasena())
                .rol(m.getRol())
                .clienteId(m.getClienteId())
                .build();
    }
}
