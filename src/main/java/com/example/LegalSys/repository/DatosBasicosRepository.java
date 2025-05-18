package com.example.LegalSys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LegalSys.model.DatosBasicos;
import com.example.LegalSys.model.Entrevistador;



@Repository
public interface DatosBasicosRepository  extends JpaRepository<DatosBasicos,Long>{
    @SuppressWarnings({ "null", "rawtypes" })
    Optional findById(Long idDatosBasicos);

}
