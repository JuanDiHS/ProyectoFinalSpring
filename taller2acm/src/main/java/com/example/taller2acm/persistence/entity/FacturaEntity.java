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
@Table(name = "factura")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long id;

    private LocalDateTime fechaEmision;
    private Integer valorTotal;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    private ReservaEntity reserva;

    @OneToOne
    @JoinColumn(name = "fk_id_pago")
    private PagoEntity pago;

    
}
