package com.example.LegalSys.dto;

import java.time.LocalDate;

import com.example.LegalSys.model.ActividadCaso;
import com.example.LegalSys.model.AreaDerecho;
import com.example.LegalSys.model.CaracterizacionSocioeconomica;
import com.example.LegalSys.model.DatosBasicos;
import com.example.LegalSys.model.EnfoqueDiferencial;
import com.example.LegalSys.model.Entrevistador;
import com.example.LegalSys.model.Estado;
import com.example.LegalSys.model.Usuario;

import lombok.Data;

@Data
public class CasoJuridicoDTO {
    
    private DatosBasicos idDatosBasicos;

    private EnfoqueDiferencial idEnfoqueDiferencial;

    private CaracterizacionSocioeconomica idCaracterizacionSocioeconomica;

    private String descripcionFactita;

    private AreaDerecho idAreaDerecho;

    private ActividadCaso idActividadCaso;

    private String conceptoJuridico;

    private Estado idEstado;

    private Entrevistador idUsuarioRegistra;

    private Usuario idUsuarioAsignado;

    private LocalDate fechaAsignacion;

}
