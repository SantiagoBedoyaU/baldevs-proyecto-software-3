package com.example.LegalSys.service;

import com.example.LegalSys.dto.DatosBasicosDTO;
import com.example.LegalSys.model.*;
import com.example.LegalSys.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatosBasicosService {

    private final DatosBasicosRepository datosBasicosRepository;
    private final UsuarioRepository usuarioRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final MunicipioRepository municipioRepository;
    private final RangoEdadRepository rangoEdadRepository;
    private final DiscapacidadRepository discapacidadRepository;
    private final SexualidadRepository sexualidadRepository;

    // Método genérico para obtener entidad obligatoria
    private <T, ID> T findOrThrow(JpaRepository<T, ID> repo, ID id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Entidad no encontrada"));
    }

    // Método genérico para obtener entidad opcional
    private <T, ID> T findOrNull(JpaRepository<T, ID> repo, ID id) {
        return id != null ? repo.findById(id).orElse(null) : null;
    }

    /**
     * Crea y persiste una nueva entidad DatosBasicos a partir del DTO recibido.
     * 
     * @param dto Objeto con la información básica del ciudadano.
     * @return La entidad persistida DatosBasicos.
     */
    public DatosBasicos crearDatosBasicos(DatosBasicosDTO dto) {
        DatosBasicos datos = mapearDtoADatosBasicos(dto);
        return datosBasicosRepository.save(datos);
    }

    // Extrae la lógica de mapeo DTO → Entidad
    private DatosBasicos mapearDtoADatosBasicos(DatosBasicosDTO dto) {
        DatosBasicos datos = new DatosBasicos();

        datos.setIdUsuarioRegistra(findOrThrow(usuarioRepository, dto.getIdUsuarioRegistra()));
        datos.setPrimerNombre(dto.getPrimerNombre());
        datos.setSegundoNombre(dto.getSegundoNombre());
        datos.setPrimerApellido(dto.getPrimerApellido());
        datos.setSegundoApellido(dto.getSegundoApellido());
        datos.setIdTipoDocumento(findOrThrow(tipoDocumentoRepository, dto.getIdTipoDocumento()));
        datos.setDocumento(dto.getDocumento());
        datos.setIdLugarExpedicion(findOrThrow(municipioRepository, dto.getIdLugarExpedicion()));
        datos.setIdRangoEdad(findOrThrow(rangoEdadRepository, dto.getIdRangoEdad()));
        datos.setCelular(dto.getCelular());
        datos.setCorreo(dto.getCorreo());
        datos.setIdDiscapacidad(findOrNull(discapacidadRepository, dto.getIdDiscapacidad()));
        datos.setIdSexualidad(findOrNull(sexualidadRepository, dto.getIdSexualidad()));
        datos.setIdCiudadDomicilio(findOrThrow(municipioRepository, dto.getIdCiudadDomicilio()));
        datos.setDireccion(dto.getDireccion());
        datos.setConcepto(dto.getConcepto());
        datos.setAreaDerecho(dto.getIdAreaDerecho()); // Validar si debe ser un objeto completo o ID

        return datos;
    }
}
