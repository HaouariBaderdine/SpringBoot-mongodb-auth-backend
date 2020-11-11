package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Emploi {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max = 20)
    private String lien;
	
	@NotBlank
    @Size(max = 20)
    private String nom;
	
	@NotBlank
    @Size(max = 20)
    private String idCollege;

	public Emploi(@NotBlank @Size(max = 20) String lien, @NotBlank @Size(max = 20) String nom, String idCollege) {
		this.lien = lien;
		this.nom = nom;
		this.idCollege = idCollege;
	}

	public String getId() {
		return id;
	}

	public String getLien() {
		return lien;
	}

	public String getNom() {
		return nom;
	}

	public String getIdCollege() {
		return idCollege;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setIdCollege(String idCollege) {
		this.idCollege = idCollege;
	}
	

}
