package com.example.taller2acm.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDTO {
    private Long id;

    @NotNull(message = "La fecha de emisión no puede ser nula")
    private LocalDateTime fechaEmision;

    @NotNull(message = "El valor total no puede ser nulo")
    private Integer valorTotal;

    @NotNull(message = "El id de la reserva no puede ser nulo")
    private Long reservaId;

    @NotNull(message = "El id del pago no puede ser nulo")
    private Long pagoId;
}
