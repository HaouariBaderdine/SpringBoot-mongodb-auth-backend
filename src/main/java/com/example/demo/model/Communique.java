package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Communique {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max = 20)
    private String lien;
	
	@NotBlank
    @Size(max = 20)
    private String libelle;
	
	@NotBlank
    @Size(max = 20)
    private String dateC;
	
	@NotBlank
    @Size(max = 20)
    private String idCollege;

		
	public Communique(@NotBlank @Size(max = 20) String lien, @NotBlank @Size(max = 20) String libelle,
			@NotBlank @Size(max = 20) String dateC, String idCollege) {
		this.lien = lien;
		this.libelle = libelle;
		this.dateC = dateC;
		this.idCollege = idCollege;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getLien() {
		return lien;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getDateC() {
		return dateC;
	}

	public String getIdCollege() {
		return idCollege;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDateC(String dateC) {
		this.dateC = dateC;
	}

	public void setIdCollege(String idCollege) {
		this.idCollege = idCollege;
	}
	

	
}
