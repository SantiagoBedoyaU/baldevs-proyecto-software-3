package com.example.LegalSys;

import com.example.LegalSys.dto.DatosBasicosDTO;
import com.example.LegalSys.model.*;
import com.example.LegalSys.repository.*;
import com.example.LegalSys.service.DatosBasicosService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DatosBasicosServiceTest {

    @InjectMocks
    private DatosBasicosService datosBasicosService;

    @Mock private DatosBasicosRepository datosBasicosRepository;
    @Mock private UsuarioRepository usuarioRepository;
    @Mock private TipoDocumentoRepository tipoDocumentoRepository;
    @Mock private MunicipioRepository municipioRepository;
    @Mock private RangoEdadRepository rangoEdadRepository;
    @Mock private DiscapacidadRepository discapacidadRepository;
    @Mock private SexualidadRepository sexualidadRepository;
    @Mock private AreaDerechoRepository areaDerechoRepository;

    @Mock
    private org.modelmapper.ModelMapper modelMapper;

    private DatosBasicosDTO dto;
    private Usuario usuario;
    private TipoDocumento tipoDocumento;
    private Municipio lugarExpedicion;
    private Municipio ciudadDomicilio;
    private RangoEdad rangoEdad;
    private Discapacidad discapacidad;
    private Sexualidad sexualidad;
    private AreaDerecho areaDerecho;

    @BeforeEach
    public void setUp() {
        // Crear entidades simuladas
        usuario = new Usuario(); usuario.setId(1L);
        tipoDocumento = new TipoDocumento(); tipoDocumento.setId(2L);
        lugarExpedicion = new Municipio(); lugarExpedicion.setId(3L);
        ciudadDomicilio = new Municipio(); ciudadDomicilio.setId(4L);
        rangoEdad = new RangoEdad(); rangoEdad.setId(5L);
        discapacidad = new Discapacidad(); discapacidad.setId(6L);
        sexualidad = new Sexualidad(); sexualidad.setId(7L);
        areaDerecho = new AreaDerecho(); areaDerecho.setId(8L);

        // Configurar el DTO
        dto = new DatosBasicosDTO();
        dto.setIdUsuarioRegistra(1L);
        dto.setPrimerNombre("Juan");
        dto.setSegundoNombre("Carlos");
        dto.setPrimerApellido("Pérez");
        dto.setSegundoApellido("Gómez");
        dto.setIdTipoDocumento(2L);
        dto.setDocumento("123456789");
        dto.setIdLugarExpedicion(3L);
        dto.setIdCiudadDomicilio(4L);
        dto.setIdRangoEdad(5L);
        dto.setCelular("3001234567");
        dto.setCorreo("juan@example.com");
        dto.setIdDiscapacidad(6L);
        dto.setIdSexualidad(7L);
        dto.setDireccion("Calle 123");
        dto.setConcepto("Test");
        dto.setIdAreaDerecho(areaDerecho);

        // Simular comportamiento de los repositorios
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(tipoDocumentoRepository.findById(2L)).thenReturn(Optional.of(tipoDocumento));
        when(municipioRepository.findById(3L)).thenReturn(Optional.of(lugarExpedicion));
        when(municipioRepository.findById(4L)).thenReturn(Optional.of(ciudadDomicilio));
        when(rangoEdadRepository.findById(5L)).thenReturn(Optional.of(rangoEdad));
        when(discapacidadRepository.findById(6L)).thenReturn(Optional.of(discapacidad));
        when(sexualidadRepository.findById(7L)).thenReturn(Optional.of(sexualidad));
    }

    @Test
    public void testCrearDatosBasicos() {
        DatosBasicos guardado = new DatosBasicos();
        guardado.setId(100L);

        when(datosBasicosRepository.save(any(DatosBasicos.class))).thenReturn(guardado);

        DatosBasicos resultado = datosBasicosService.crearDatosBasicos(dto);

        assertNotNull(resultado);
        assertEquals(100L, resultado.getId());

        verify(usuarioRepository).findById(1L);
        verify(tipoDocumentoRepository).findById(2L);
        verify(municipioRepository).findById(3L);
        verify(municipioRepository).findById(4L);
        verify(rangoEdadRepository).findById(5L);
        verify(discapacidadRepository).findById(6L);
        verify(sexualidadRepository).findById(7L);
        verify(datosBasicosRepository).save(any(DatosBasicos.class));
    }
}
