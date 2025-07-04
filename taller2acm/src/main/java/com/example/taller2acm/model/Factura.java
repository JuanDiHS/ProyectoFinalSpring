package com.example.taller2acm.model;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    private Long id;
    private LocalDateTime fechaEmision;
    private Integer valorTotal;
    private Long reservaId;
    private Long pagoId;
}