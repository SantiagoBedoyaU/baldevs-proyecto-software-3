package com.example.LegalSys.dto;

import lombok.Data;

@Data
public class DatosBasicosDTO {
    private Long idUsuarioRegistra;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long idTipoDocumento;
    private String documento;
    private Long idLugarExpedicion;
    private Long idRangoEdad;
    private String celular;
    private String correo;
    private Long idDiscapacidad;
    private Long idSexualidad;
    private Long idCiudadDomicilio;
    private String direccion;
    private String concepto;
    private Long idAreaDerecho;
}
