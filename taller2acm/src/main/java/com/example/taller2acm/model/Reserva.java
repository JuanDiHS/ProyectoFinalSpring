package com.example.taller2acm.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
public class Reserva {
    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Integer cantidadDias;
    private Boolean estado;
    private LocalDateTime fechaReserva;
    private Long clienteId;
    private Long habitacionId;

}
