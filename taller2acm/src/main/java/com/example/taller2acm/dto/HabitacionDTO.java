package com.example.taller2acm.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionDTO {
    private Long id;

    @NotNull(message = "El número de habitación no puede ser nulo")
    private Integer numeroHabitacion;

    @NotNull(message = "El precio por día no puede ser nulo")
    private Integer precioDia;

    private Boolean disponible;

    @NotNull(message = "El id del hotel no puede ser nulo")
    private Long hotelId;

    @NotNull(message = "El id del tipo de habitación no puede ser nulo")
    private Long tipoHabitacionId;
}
