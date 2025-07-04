package com.example.taller2acm.model;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    private Long id;
    private LocalDateTime fecha;
    private String metodoPago;
    private Integer pagoTotal;
    private Long reservaId;
}