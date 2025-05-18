package com.example.LegalSys.model;


import java.util.List;
import java.util.Optional;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@Entity
@Table(name = "area_derecho")
public class AreaDerecho {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nombre;



    
}
