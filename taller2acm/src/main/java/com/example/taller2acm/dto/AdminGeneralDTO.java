package com.example.taller2acm.dto;
import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminGeneralDTO {
    private Long id;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "Debe ser un correo válido")
    private String correo;

    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefono;

    @NotBlank(message = "El primer nombre no puede estar vacío")
    private String primerNombre;

    private String segundoNombre;

    @NotBlank(message = "El primer apellido no puede estar vacío")
    private String primerApellido;

    private String segundoApellido;
}