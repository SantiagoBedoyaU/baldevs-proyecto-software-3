package com.example.LegalSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LegalSys.model.Discapacidad;



@Repository
public interface DiscapacidadRepository  extends JpaRepository<Discapacidad,Long>{


}

