package com.example.taller2acm.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva")
    private Long id;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Integer cantidadDias;
    private Boolean estado;
    private LocalDateTime fechaReserva;

    @ManyToOne
    @JoinColumn(name = "fk_id_habitacion")
    private HabitacionEntity habitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "reserva")
    private List<PagoEntity> pagos;

    @OneToMany(mappedBy = "reserva")
    private List<FacturaEntity> facturas;

    
}


