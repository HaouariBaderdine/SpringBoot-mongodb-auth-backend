package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class College {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max = 20)
    private String nom;

	@NotBlank
    @Size(max = 20)
    private String ville;
	
	
	public College(@NotBlank @Size(max = 20) String nom) {
		this.nom = nom;
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getVille() {
		return ville;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
