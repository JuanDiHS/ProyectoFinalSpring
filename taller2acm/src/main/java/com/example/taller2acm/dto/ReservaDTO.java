package com.example.taller2acm.dto;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
@Getter
@Setter
public class ReservaDTO {
    private Long clienteId;

    @NotBlank(message = "El campo no puede estar vacío")
     private LocalDateTime fechaInicio;
     @NotBlank
    private LocalDateTime fechaFinal;
    @NotBlank(message = "El campo no puede estar vacío")
    private int cantidadDias;
    private boolean estado;
    private LocalDateTime fechaReserva;

}
