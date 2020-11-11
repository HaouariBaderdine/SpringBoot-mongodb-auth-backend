package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Eleve {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max = 50)
    private String nom;
    
    @NotBlank
    @Size(max = 50)
    private String prenom;
    
    
    @NotBlank
    @Size(max = 50)
    private String dateNaissance;
    
    @NotBlank
    @Size(max = 20)
    private String classe;
    
    @NotBlank
    @Size(max = 20)
    private String idCollege;
    

	public Eleve(@NotBlank @Size(max = 50) String nom, @NotBlank @Size(max = 50) String prenom,
			@NotBlank @Size(max = 50) String dateNaissance, @NotBlank @Size(max = 20) String classe,
			@NotBlank @Size(max = 20) String idCollege) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.classe = classe;
		this.idCollege = idCollege;
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public String getClasse() {
		return classe;
	}

	public String getIdCollege() {
		return idCollege;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public void setIdCollege(String idCollege) {
		this.idCollege = idCollege;
	}
    
    
}
