package com.projet.beans;

import java.sql.Timestamp;

public class utilisateur {
	
	 private Long	id; 
     private String	nomutilisateur;
	 private String email;
	 private String motDePasse;
	 private Timestamp dateInscription;
	 
	
	 public Long getId() {
			return id;
	}
	public void setId(Long id) {
			this.id = id;
	} 
	public String getNomutilisateur() {
		return nomutilisateur;
	}
	public void setNomutilisateur(String nomutilisateur) {
		this.nomutilisateur = nomutilisateur;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Timestamp getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Timestamp dateInscription) {
		this.dateInscription = dateInscription;
	}

}
