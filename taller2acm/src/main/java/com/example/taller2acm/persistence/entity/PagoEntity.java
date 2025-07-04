package com.example.taller2acm.persistence.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pago")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    private LocalDateTime fecha;
    private String metodoPago;
    private Integer pagoTotal;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    private ReservaEntity reserva;

    @OneToOne(mappedBy = "pago")
    private FacturaEntity factura;

    
}