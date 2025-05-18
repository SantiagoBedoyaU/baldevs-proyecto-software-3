package com.example.LegalSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LegalSys.model.CasoJuridico;



@Repository
public interface CasoJuridicoRepository  extends JpaRepository<CasoJuridico,Long>{



}
