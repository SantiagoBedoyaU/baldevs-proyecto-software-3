package com.example.LegalSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LegalSys.model.Sexualidad;



@Repository
public interface SexualidadRepository  extends JpaRepository<Sexualidad,Long>{


}

