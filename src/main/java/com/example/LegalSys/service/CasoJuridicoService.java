package com.example.LegalSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.LegalSys.dto.CasoJuridicoDTO;
import com.example.LegalSys.model.CaracterizacionSocioeconomica;
import com.example.LegalSys.model.CasoJuridico;
import com.example.LegalSys.model.DatosBasicos;
import com.example.LegalSys.model.EnfoqueDiferencial;
import com.example.LegalSys.model.Entrevistador;

import com.example.LegalSys.repository.CaracterizacionSocioeconomicaRepository;
import com.example.LegalSys.repository.CasoJuridicoRepository;
import com.example.LegalSys.repository.DatosBasicosRepository;
import com.example.LegalSys.repository.EnfoqueDiferencialRepository;
import com.example.LegalSys.repository.EntrevistadorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CasoJuridicoService {

    @Autowired
    private CaracterizacionSocioeconomicaRepository caracterizacionSocioeconomicaRepo;

    @Autowired
    private CasoJuridicoRepository casoJuridicoRepo;

    @Autowired
    private EnfoqueDiferencialRepository enfoqueDiferencialRepo;

    @Autowired
    private EntrevistadorRepository entrevistadorRepo;

    @Autowired
    private DatosBasicosRepository datosBasicosRepo;

    /**
     * Guarda un caso jurídico y sus entidades relacionadas
     * 
     * @param casoJuridicoDTO DTO con la información del caso jurídico
     * @return El caso jurídico guardado
     * @throws Throwable 
     */
    @Transactional
    public CasoJuridico guardarCasoJuridico(CasoJuridicoDTO casoJuridicoDTO) throws Throwable {

        // 1. Guardar entidades relacionadas primero
        EnfoqueDiferencial enfoqueGuardado = guardarEnfoqueDiferencial(casoJuridicoDTO.getIdEnfoqueDiferencial());
        CaracterizacionSocioeconomica caracterizacionGuardada = guardarCaracterizacionSocioeconomica(casoJuridicoDTO.getIdCaracterizacionSocioeconomica());
        Entrevistador entrevistadorGuardado = guardarEntrevistador(casoJuridicoDTO.getIdUsuarioRegistra());

        // 2. Crear y poblar el CasoJuridico
        CasoJuridico casoJuridico = new CasoJuridico();


        DatosBasicos datosBasicosPersistente = null;
        if (casoJuridicoDTO.getIdDatosBasicos() != null && casoJuridicoDTO.getIdDatosBasicos().getId() != null) {
            Long idDatosBasicos = casoJuridicoDTO.getIdDatosBasicos().getId(); // Asegúrate de obtener el tipo de ID correcto
            datosBasicosPersistente = (DatosBasicos) datosBasicosRepo.findById(idDatosBasicos)
                    .orElseThrow(() -> new EntityNotFoundException("DatosBasicos no encontrado con ID: " + idDatosBasicos));
        } else {
            // Manejar el caso donde no se provee idDatosBasicos o es nulo,
            // podría ser un error o podrías necesitar crear uno nuevo si la lógica lo permite.
            // Por ahora, lanzaremos un error si es requerido y no se encuentra.
            throw new IllegalArgumentException("ID de DatosBasicos es requerido y no fue encontrado o es nulo.");
            }        
               
        casoJuridico.setIdDatosBasicos(datosBasicosPersistente);
        casoJuridico.setIdEnfoqueDiferencial(enfoqueGuardado);
        casoJuridico.setIdCaracterizacionSocioeconomica(caracterizacionGuardada);
        casoJuridico.setIdUsuarioRegistra(entrevistadorGuardado);

        casoJuridico.setDescripcionFactita(casoJuridicoDTO.getDescripcionFactita());
        casoJuridico.setIdAreaDerecho(casoJuridicoDTO.getIdAreaDerecho());
        casoJuridico.setIdActividadCaso(casoJuridicoDTO.getIdActividadCaso());
        casoJuridico.setConceptoJuridico(casoJuridicoDTO.getConceptoJuridico());
        casoJuridico.setIdEstado(casoJuridicoDTO.getIdEstado());
        casoJuridico.setIdUsuarioAsignado(casoJuridicoDTO.getIdUsuarioAsignado());
        casoJuridico.setFechaAsignacion(casoJuridicoDTO.getFechaAsignacion());

        // 3. Guardar el caso jurídico
        return casoJuridicoRepo.save(casoJuridico);
    }

    private EnfoqueDiferencial guardarEnfoqueDiferencial(EnfoqueDiferencial enfoqueDiferencial) {
        return enfoqueDiferencialRepo.save(enfoqueDiferencial);
    }

    private CaracterizacionSocioeconomica guardarCaracterizacionSocioeconomica(CaracterizacionSocioeconomica caracterizacionSocioeconomica) {
        return caracterizacionSocioeconomicaRepo.save(caracterizacionSocioeconomica);
    }

    private Entrevistador guardarEntrevistador(Entrevistador entrevistador) {
        return entrevistadorRepo.save(entrevistador);
    }
}
