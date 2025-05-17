package com.example.LegalSys.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "caracterizacion_socioeconomica")
public class CaracterizacionSocioeconomica {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String ocupacion;

    @ManyToOne
    @JoinColumn(name = "id_promedio_ingresos_personales",
                referencedColumnName = "id",
                nullable = false)
    private RangoMonetario idPromedioIngresoPersonal;

    @Column(nullable = false, name = "personas_laburando")
    private String personasLaburando;

    @ManyToOne
    @JoinColumn(name = "id_promedio_ingresos_familiares",
                referencedColumnName = "id",
                nullable = false)
    private RangoMonetario idPromedioIngresoFamiliares;



    @ManyToOne
    @JoinColumn(name = "id_promedio_egresos",
                referencedColumnName = "id",
                nullable = false)
    private RangoMonetario idPromedioEgresos;


    @Column(nullable = false, name = "personas_conviven")
    private Integer personasConviven;


    @ManyToOne
    @JoinColumn(name = "id_estrato",
                referencedColumnName = "id",
                nullable = false)
    private Estrato idEstrato;


    @Column(nullable = false, length = 1)
    private String dependientes;

    @Column(name = "numero_dependientes")
    private Integer numeroDependientes;

    @Column(nullable = false, length = 1)
    private String depende;

    @Column(length = 1)
    private String dependeAbogado;
    

    @ManyToOne
    @JoinColumn(name = "id_tipo_vivienda",
                referencedColumnName = "id",
                nullable = false)
    private TipoVivienda idTipoVivienda;


    @Column(nullable = false, length = 1)
    private String asesorado;

    @Column(nullable = false)
    private String observaciones;
    
}
