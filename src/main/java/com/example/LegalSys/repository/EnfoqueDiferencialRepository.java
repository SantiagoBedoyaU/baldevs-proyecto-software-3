package com.example.LegalSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LegalSys.model.EnfoqueDiferencial;



@Repository
public interface EnfoqueDiferencialRepository  extends JpaRepository<EnfoqueDiferencial,Long>{


}

