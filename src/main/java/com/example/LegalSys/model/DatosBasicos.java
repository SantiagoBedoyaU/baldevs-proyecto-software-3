package com.example.LegalSys.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
@Entity
@Table(name = "datos_basicos")
public class DatosBasicos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario_registra",
                referencedColumnName = "id",
                nullable = false)
	private Usuario idUsuarioRegistra;

    @NotBlank(message="El primer nombre no puede estar vacío")
    @Column(nullable = false)
    private String primerNombre;
    private String segundoNombre;
    @NotBlank(message="El primer apellido no puede estar vacío")
    @Column(nullable = false)
    private String primerApellido;
    private String segundoApellido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento",
                referencedColumnName = "id",
                nullable = false)
    private TipoDocumento idTipoDocumento;

    @Column(nullable = false)
    private String documento;

    @ManyToOne
    @JoinColumn(name = "id_lugar_expedicion",
                referencedColumnName = "id",
                nullable = false)
    private Municipio idLugarExpedicion;

    @ManyToOne
    @JoinColumn(name = "id_rango_edad",
                referencedColumnName = "id",
                nullable = false)
    private RangoEdad idRangoEdad;

    private String Celular;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_discapacidad",
                referencedColumnName = "id")
    private Discapacidad idDiscapacidad;

    @ManyToOne
    @JoinColumn(name = "id_sexualidad",
                referencedColumnName = "id")
    private Sexualidad idSexualidad;

    @ManyToOne
    @JoinColumn(name = "id_ciudad_domicilio",
                referencedColumnName = "id",
                nullable = false)
    private Municipio idCiudadDomicilio;

    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String concepto;
    

    @ManyToOne
    @JoinColumn(name = "id_area_derecho", referencedColumnName = "id", nullable = false)
    private AreaDerecho areaDerecho;

}
