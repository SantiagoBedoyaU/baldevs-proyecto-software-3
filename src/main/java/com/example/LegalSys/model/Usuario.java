package com.example.LegalSys.model;


import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="El primer nombre no puede estar vacío")
    @Column(nullable = false)
    private String primerNombre;
    private String segundoNombre;
    @NotBlank(message="El primer apellido no puede estar vacío")
    @Column(nullable = false)
    private String primerApellido;
    private String segundoApellido;
   
    private Long codigoEstudiante;
    
    private String codigoDocente;

    @ManyToOne
    @JoinColumn(name = "id_area_derecho",
                referencedColumnName = "id")
    private AreaDerecho areaDerecho;


    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private LocalDate fechaCreaciom;

    @Column(nullable = false, length = 1)
    private String activo;

    @ManyToOne
    @JoinColumn(name = "id_rol",
                referencedColumnName = "id")
    private Rol idRol;

}
