package com.example.taller2acm.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "habitacion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HabitacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long id;

    private Integer numeroHabitacion;
    private Integer precioDia;
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private HotelEntity hotel;

    @OneToOne
    @JoinColumn(name = "fk_id_tipo_habitacion")
    private TipoHabitacionEntity tipoHabitacion;

    @OneToMany(mappedBy = "habitacion")
    private List<ReservaEntity> reservas;

    
}