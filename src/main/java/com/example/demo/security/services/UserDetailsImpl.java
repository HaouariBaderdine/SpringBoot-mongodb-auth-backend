package com.example.demo.security.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String email;
    private String nom;
    private String prenom;
    private String adresse;
    private String numtel;
    private String mat;
    private String idCollege;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String id,String username, String email, String password,
    		String nom,String prenom,String adresse,String numtel,String idCollege,
                           Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numtel = numtel;
        this.idCollege = idCollege;
        this.authorities  = authorities ;
    }
    
    public UserDetailsImpl(String id,String username, String email, String password,
    		String nom,String prenom,String adresse,String numtel,String mat,String idCollege,
                           Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numtel = numtel;
        this.setIdCollege(idCollege);
        this.mat = mat;
        this.authorities  = authorities ;
    }
    
   

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
        		user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getNom(),
                user.getPrenom(),
                user.getAdresse(),
                user.getNumtel(),
                user.getIdCollege(),
                user.getMat(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
    
    public String getMat() {
		return mat;
	}

	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCollege() {
		return idCollege;
	}

	public void setIdCollege(String idCollege) {
		this.idCollege = idCollege;
	}

    
}
