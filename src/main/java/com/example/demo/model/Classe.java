package com.example.demo.model;


import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Classe {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max = 20)
    private String designation;
	
	@NotBlank
    @Size(max = 20)
    private String idCollege;
	
	@DBRef
    private Set<Eleve> listeEleves = new HashSet<Eleve>();
    
	@DBRef
    private Set<User> listeProfs = new HashSet<User>();
    
	public Classe(@NotBlank @Size(max = 20) String designation, @NotBlank @Size(max = 20) String idCollege,
			Set<Eleve> listeEleves, Set<User> listeProfs) {
		this.designation = designation;
		this.idCollege = idCollege;
		this.listeEleves = listeEleves;
		this.listeProfs = listeProfs;
	}

	public String getId() {
		return id;
	}

	public String getDesignation() {
		return designation;
	}

	public String getIdCollege() {
		return idCollege;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setIdCollege(String idCollege) {
		this.idCollege = idCollege;
	}

	
}
