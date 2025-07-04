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
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String nombreUsuario;
    private String contrasena;
    private String rol;

    @OneToOne
    @JoinColumn(name = "fk_id_cliente")
    private ClienteEntity cliente;

    @OneToOne
    @JoinColumn(name = "fk_id_empleado")
    private EmpleadoEntity empleado;

    @OneToOne
    @JoinColumn(name = "fk_id_administrador_general")
    private AdminGeneralEntity administradorGeneral;

    
}