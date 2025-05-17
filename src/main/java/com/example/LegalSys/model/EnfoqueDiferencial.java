package com.example.LegalSys.model;


import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
@Entity
@Table(name = "enfoque_diferencial")
public class EnfoqueDiferencial {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 1)
    private String victimaConflictoArm;

    @ManyToOne
    @JoinColumn(name = "id_sexualidad",
                referencedColumnName = "id",
                nullable = false)
    private Sexualidad idSexualidad;
    

    @ManyToOne
    @JoinColumn(name = "Identidad_de_Genero",
                referencedColumnName = "id",
                nullable = false)
    private Sexualidad identidadGenero;
    
    @Column(nullable = false, length = 1)
    private String lgbtiq;


    @ManyToOne
    @JoinColumn(name = "id_etnia",
                referencedColumnName = "id",
                nullable = false)
    private Etnia idEtnia;

    @ManyToOne
    @JoinColumn(name = "id_discapacidad",
                referencedColumnName = "id",
                nullable = false)
    private Discapacidad idDiscapacidad;

    @Column(nullable = false, length = 1)
    private String campesino;

    @Column(nullable = false, length = 1)
    private String interseccionalidad;

    @Column(name = "victima_violencia",nullable = false, length = 1)
    private String victimaViolencia;

    @Column(nullable = false, length = 1)
    private String enfoque;

    @Column(name = "concepto_enfoque")
    private String conceptoEnfoque;

}
