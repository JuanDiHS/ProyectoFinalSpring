package com.example.taller2acm.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Long id;

    private String nombre;
    private String ciudad;
    private String telefono;
    private String correo;
    private String direccion;

    @OneToMany(mappedBy = "hotel")
    private List<TipoHabitacionEntity> tiposHabitacion;

    @OneToMany(mappedBy = "hotel")
    private List<HabitacionEntity> habitaciones;

    
}
