package com.example.taller2acm.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacion {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private Long hotelId;
}
