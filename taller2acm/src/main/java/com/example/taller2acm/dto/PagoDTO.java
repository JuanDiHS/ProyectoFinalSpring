package com.example.taller2acm.dto;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private Long id;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDateTime fecha;

    @NotBlank(message = "El método de pago no puede estar vacío")
    private String metodoPago;

    @NotNull(message = "El pago total no puede ser nulo")
    private Integer pagoTotal;

    @NotNull(message = "El id de la reserva no puede ser nulo")
    private Long reservaId;
}
