package com.example.LegalSys.controller;

import com.example.LegalSys.dto.DatosBasicosDTO;
import com.example.LegalSys.model.DatosBasicos;
import com.example.LegalSys.service.DatosBasicosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/datos-basicos")
@RequiredArgsConstructor
@CrossOrigin
public class DatosBasicosController {

    private final DatosBasicosService datosBasicosService;

    @PostMapping
    public ResponseEntity<DatosBasicos> crearDatos(@Valid @RequestBody DatosBasicosDTO dto) {
        DatosBasicos nuevo = datosBasicosService.crearDatosBasicos(dto);
        return ResponseEntity.ok(nuevo);
    }
}
