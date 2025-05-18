package com.example.LegalSys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.LegalSys.dto.CasoJuridicoDTO;
import com.example.LegalSys.model.CasoJuridico;
import com.example.LegalSys.service.CasoJuridicoService;



@RestController
@RequestMapping("/legalsys/casojuridico")
public class CasoJuridicoController {

    @Autowired
    private CasoJuridicoService casoJuridicoService;

    @PostMapping("/create")
    public ResponseEntity<CasoJuridico> guardarCasoJuridico(@RequestBody CasoJuridicoDTO casoDTO) throws Throwable{
    	CasoJuridico casoJuridico = casoJuridicoService.guardarCasoJuridico(casoDTO);
    	return ResponseEntity.status(201).body(casoJuridico);
    }
    
    
}
