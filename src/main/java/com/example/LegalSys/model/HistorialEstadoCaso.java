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
@Table(name = "historial_estado_caso")
public class HistorialEstadoCaso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_caso_juridico",
                referencedColumnName = "id",
                nullable = false)
    private CasoJuridico idCasoJuridico;

    @ManyToOne
    @JoinColumn(name = "id_estado_caso",
                referencedColumnName = "id",
                nullable = false)
    private Estado idEstadoCaso;
    
    @Column(name = "fecha_estado",nullable = false)
    private LocalDate fechaEstado;
    
    @ManyToOne
    @JoinColumn(name = "usuario_actualiza",
                referencedColumnName = "id",
                nullable = false)
    private Usuario idUsuario;
}
