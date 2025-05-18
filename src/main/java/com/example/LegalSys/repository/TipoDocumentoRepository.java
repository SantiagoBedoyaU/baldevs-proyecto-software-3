package com.example.LegalSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LegalSys.model.TipoDocumento;



@Repository
public interface TipoDocumentoRepository  extends JpaRepository<TipoDocumento,Long>{


}

