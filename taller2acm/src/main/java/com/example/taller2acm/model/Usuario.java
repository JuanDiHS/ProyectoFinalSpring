package com.example.taller2acm.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombreUsuario;
    private String contrasena;
    private String rol;
    private Long clienteId;
    private Long empleadoId;
    private Long administradorGeneralId;
}
