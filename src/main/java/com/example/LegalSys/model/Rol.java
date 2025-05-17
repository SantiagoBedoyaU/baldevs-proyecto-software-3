package com.example.LegalSys.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "rol")
public class Rol {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nombre;
    
}
