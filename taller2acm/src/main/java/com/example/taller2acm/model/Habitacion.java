package com.example.taller2acm.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {
    private Long id;
    private Integer numeroHabitacion;
    private Integer precioDia;
    private Boolean disponible;
    private Long hotelId;
    private Long tipoHabitacionId;
}