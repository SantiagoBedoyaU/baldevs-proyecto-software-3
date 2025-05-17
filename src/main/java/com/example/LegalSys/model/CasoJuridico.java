package com.example.LegalSys.model;


import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "caso_juridico")
public class CasoJuridico {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_datos_basicos", referencedColumnName = "id", nullable = false)
    private DatosBasicos idDatosBasicos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_enfoque_diferencial", referencedColumnName = "id", nullable = false)
    private EnfoqueDiferencial idEnfoqueDiferencial;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caracterizacion_socioeconomica", referencedColumnName = "id", nullable = false)
    private CaracterizacionSocioeconomica idCaracterizacionSocioeconomica;

    @Column(nullable = false, name = "descripcion_factita")
    private String descripcionFactita;

    @ManyToOne
    @JoinColumn(name = "id_area_derecho",
                referencedColumnName = "id",
                nullable = false)
    private AreaDerecho idAreaDerecho;

   
    @ManyToOne
    @JoinColumn(name = "id_actividad",
                referencedColumnName = "id",
                nullable = false)
    private ActividadCaso idActividadCaso;

    @Column(name = "concepto_juridico")
    private String conceptoJuridico;

    @ManyToOne
    @JoinColumn(name = "id_estado_caso",
                referencedColumnName = "id",
                nullable = false)
    private Estado idEstado;

    @ManyToOne
    @JoinColumn(name = "id_usuario_registra",
                referencedColumnName = "id",
                nullable = false)
    private Usuario idUsuarioRegistra;

    @ManyToOne
    @JoinColumn(name = "id_usuario_asignado",
                referencedColumnName = "id")
    private Usuario idUsuarioAsignado;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;


}
