package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="users")
public class User {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;
    
    @NotBlank
    @Size(max = 120)
    private String mat;
    
    @NotBlank
    @Size(max = 50)
    private String nom;
    
    @NotBlank
    @Size(max = 50)
    private String prenom;
    
    @NotBlank
    @Size(max = 50)
    private String adresse;
    
    @NotBlank
    @Size(min = 8, max = 8)
    private String numtel;
    
    @NotBlank
    @Size(max = 20)
    private String idCollege;

	@DBRef
    private Set<Role> roles = new HashSet<>();
    
    
	public User() {
		// TODO Auto-generated constructor stub
	}

	 public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
				@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 50) String nom,
				@NotBlank @Size(max = 50) String prenom, @NotBlank @Size(max = 50) String adresse,
				@NotBlank @Size(max = 8) String numtel,String idCollege
				) {
			this.username = username;
			this.email = email;
			this.password = password;
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.numtel = numtel;
			this.idCollege = idCollege;
		}
	 
	 public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
				@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 50) String nom,
				@NotBlank @Size(max = 50) String prenom, @NotBlank @Size(max = 50) String adresse,
				@NotBlank @Size(max = 8) String numtel,String idCollege,String mat
				) {
			this.username = username;
			this.email = email;
			this.password = password;
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.numtel = numtel;
			this.idCollege = idCollege;
			this.mat = mat;
		}
	 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

	public String getIdCollege() {
		return idCollege;
	}

	public void setIdCollege(String idCollege) {
		this.idCollege = idCollege;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}
	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
		
}

