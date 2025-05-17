package com.example.LegalSys.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
@Entity
@Table(name = "entrevistador")
public class Entrevistador {
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

    @ManyToOne
    @JoinColumn(name = "id_usuario",
                referencedColumnName = "id",
                nullable = false)
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "hoja_vida",
                referencedColumnName = "id")
    private AreaDerecho hojaVida;

    @Column(name = "fecha_entrevista")
    private LocalDate fechaEntrevista;

    private String observacion;
}
