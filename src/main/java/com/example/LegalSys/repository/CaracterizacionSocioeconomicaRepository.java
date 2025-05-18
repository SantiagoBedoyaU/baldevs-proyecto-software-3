package com.example.LegalSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LegalSys.model.CaracterizacionSocioeconomica;



@Repository
public interface CaracterizacionSocioeconomicaRepository  extends JpaRepository<CaracterizacionSocioeconomica,Long>{


}
