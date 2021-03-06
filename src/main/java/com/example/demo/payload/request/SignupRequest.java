package com.example.demo.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
public class SignupRequest {
	

	@NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

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
    @Size(max = 8)
    private String numtel;
    
    @NotBlank
    @Size(max = 20)
    private String idCollege;
    
    @NotBlank
    @Size(max = 50)
    private String mat;

	private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    

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
	
	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	
    public String getIdCollege() {
		return idCollege;
	}

	public void setIdCollege(String idCollege) {
		this.idCollege = idCollege;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public Set<String> getRoles() {
        return this.roles;
    }

    public void setRole(Set<String> roles) {
        this.roles = roles;
    }
}
