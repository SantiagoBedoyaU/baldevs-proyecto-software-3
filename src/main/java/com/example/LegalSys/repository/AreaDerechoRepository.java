package com.example.LegalSys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LegalSys.model.AreaDerecho;



@Repository
public interface AreaDerechoRepository  extends JpaRepository<AreaDerecho,Long>{
    @SuppressWarnings({ "null", "rawtypes" })
    Optional findById(Long areaDerechoId);

}
