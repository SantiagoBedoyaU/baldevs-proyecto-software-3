package com.example.LegalSys;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import com.example.LegalSys.dto.CasoJuridicoDTO;
import com.example.LegalSys.model.*;
import com.example.LegalSys.repository.*;
import com.example.LegalSys.service.CasoJuridicoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CasoJuridicoServiceTest {

    @InjectMocks
    private CasoJuridicoService casoJuridicoService;

    @Mock
    private CasoJuridicoRepository casoJuridicoRepo;

    @Mock
    private EnfoqueDiferencialRepository enfoqueDiferencialRepo;

    @Mock
    private CaracterizacionSocioeconomicaRepository caracterizacionSocioeconomicaRepo;

    @Mock
    private EntrevistadorRepository entrevistadorRepo;

    @Mock
    private DatosBasicosRepository datosBasicosRepo;

    private CasoJuridicoDTO casoJuridicoDTO;

    private DatosBasicos datosBasicos;
    private EnfoqueDiferencial enfoqueDiferencial;
    private CaracterizacionSocioeconomica caracterizacionSocioeconomica;
    private Entrevistador entrevistador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Crear datos simulados para las entidades relacionadas
        datosBasicos = new DatosBasicos();
        datosBasicos.setId(1L);

        enfoqueDiferencial = new EnfoqueDiferencial();
        enfoqueDiferencial.setId(2L);

        caracterizacionSocioeconomica = new CaracterizacionSocioeconomica();
        caracterizacionSocioeconomica.setId(3L);

        entrevistador = new Entrevistador();
        entrevistador.setId(4L);

        // Construir DTO con estas entidades
        casoJuridicoDTO = new CasoJuridicoDTO();
        casoJuridicoDTO.setIdDatosBasicos(datosBasicos);
        casoJuridicoDTO.setIdEnfoqueDiferencial(enfoqueDiferencial);
        casoJuridicoDTO.setIdCaracterizacionSocioeconomica(caracterizacionSocioeconomica);
        casoJuridicoDTO.setIdUsuarioRegistra(entrevistador);
        casoJuridicoDTO.setDescripcionFactita("Descripción de prueba");
        
    }

    @Test
    public void testGuardarCasoJuridico() throws Throwable {
        // Simular que datosBasicosRepo.findById devuelve el objeto esperado
        when(datosBasicosRepo.findById(datosBasicos.getId())).thenReturn(Optional.of(datosBasicos));

        // Simular guardado de entidades relacionadas
        when(enfoqueDiferencialRepo.save(enfoqueDiferencial)).thenReturn(enfoqueDiferencial);
        when(caracterizacionSocioeconomicaRepo.save(caracterizacionSocioeconomica)).thenReturn(caracterizacionSocioeconomica);
        when(entrevistadorRepo.save(entrevistador)).thenReturn(entrevistador);

        // Simular guardado del caso jurídico
        CasoJuridico casoGuardado = new CasoJuridico();
        casoGuardado.setId(100L);
        casoGuardado.setDescripcionFactita(casoJuridicoDTO.getDescripcionFactita());
        casoGuardado.setIdDatosBasicos(datosBasicos);
        casoGuardado.setIdEnfoqueDiferencial(enfoqueDiferencial);
        casoGuardado.setIdCaracterizacionSocioeconomica(caracterizacionSocioeconomica);
        casoGuardado.setIdUsuarioRegistra(entrevistador);

        when(casoJuridicoRepo.save(any(CasoJuridico.class))).thenReturn(casoGuardado);

        // Ejecutar el método a probar
        CasoJuridico resultado = casoJuridicoService.guardarCasoJuridico(casoJuridicoDTO);

        // Verificar que el resultado no sea null y tenga el ID esperado
        assertNotNull(resultado);
        assertEquals(100L, resultado.getId());
        assertEquals("Descripción de prueba", resultado.getDescripcionFactita());

        // Verificar que se llamaron los métodos de guardado y búsqueda correctamente
        verify(datosBasicosRepo).findById(datosBasicos.getId());
        verify(enfoqueDiferencialRepo).save(enfoqueDiferencial);
        verify(caracterizacionSocioeconomicaRepo).save(caracterizacionSocioeconomica);
        verify(entrevistadorRepo).save(entrevistador);
        verify(casoJuridicoRepo).save(any(CasoJuridico.class));
    }
}
