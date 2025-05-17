package com.example.LegalSys.service;

import com.example.LegalSys.dto.DatosBasicosDTO;
import com.example.LegalSys.model.*;
import com.example.LegalSys.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final AreaDerechoRepository areaDerechoRepository;
    private final ModelMapper modelMapper;

    public DatosBasicos crearDatosBasicos(DatosBasicosDTO dto) {
        DatosBasicos datos = new DatosBasicos();
        datos.setIdUsuarioRegistra(usuarioRepository.findById(dto.getIdUsuarioRegistra()).orElseThrow());
        datos.setPrimerNombre(dto.getPrimerNombre());
        datos.setSegundoNombre(dto.getSegundoNombre());
        datos.setPrimerApellido(dto.getPrimerApellido());
        datos.setSegundoApellido(dto.getSegundoApellido());
        datos.setIdTipoDocumento(tipoDocumentoRepository.findById(dto.getIdTipoDocumento()).orElseThrow());
        datos.setDocumento(dto.getDocumento());
        datos.setIdLugarExpedicion(municipioRepository.findById(dto.getIdLugarExpedicion()).orElseThrow());
        datos.setIdRangoEdad(rangoEdadRepository.findById(dto.getIdRangoEdad()).orElseThrow());
        datos.setCelular(dto.getCelular());
        datos.setCorreo(dto.getCorreo());
        if (dto.getIdDiscapacidad() != null)
            datos.setIdDiscapacidad(discapacidadRepository.findById(dto.getIdDiscapacidad()).orElse(null));
        if (dto.getIdSexualidad() != null)
            datos.setIdSexualidad(sexualidadRepository.findById(dto.getIdSexualidad()).orElse(null));
        datos.setIdCiudadDomicilio(municipioRepository.findById(dto.getIdCiudadDomicilio()).orElseThrow());
        datos.setDireccion(dto.getDireccion());
        datos.setConcepto(dto.getConcepto());
        datos.setAreaDerecho(areaDerechoRepository.findById(dto.getIdAreaDerecho()).orElseThrow());

        return datosBasicosRepository.save(datos);
    }
}

