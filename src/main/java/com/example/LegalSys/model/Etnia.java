package com.example.LegalSys.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "etnia")
public class Etnia {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nombre;
    
}
