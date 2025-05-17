package com.example.LegalSys.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "actividad_caso")
public class ActividadCaso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nombre;
    
}
