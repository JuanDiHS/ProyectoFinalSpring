package com.example.taller2acm.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tipo_habitacion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TipoHabitacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habitacion")
    private Long id;

    private String nombre;
    private Integer cantidad;

    @OneToOne
    @JoinColumn(name = "fk_id_hotel")
    private HotelEntity hotel;

    @OneToOne(mappedBy = "tipoHabitacion")
    private HabitacionEntity habitacion;

    
}
