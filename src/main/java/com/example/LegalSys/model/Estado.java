package com.example.LegalSys.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "estado")
public class Estado {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nombre;
    
}
