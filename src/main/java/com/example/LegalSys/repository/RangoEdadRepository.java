package com.example.LegalSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LegalSys.model.RangoEdad;



@Repository
public interface RangoEdadRepository  extends JpaRepository<RangoEdad,Long>{


}

