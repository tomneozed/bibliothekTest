package com.DAO.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="pret")
@Table(name="pret")
public class PretPojo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="date_debut_pret")
	private Date dateDebutPret;
	
	@Column(name="date_fin_pret")
	private Date dateFinPret;

	private String etat;
	
	private boolean prolongation;
	
	@Column(name="id_utilisateur")
	private int idOuvrage;
	
	@Column(name="id_ouvrage")
	private int idUtilisateur;
	
	public PretPojo() {
		super();
	}

	public PretPojo(int id, Date dateDebutPret, Date dateFinPret, String etat, int idOuvrage, int idUtilisateur, boolean prolongation) {
		super();
		this.id = id;
		this.dateDebutPret = dateDebutPret;
		this.dateFinPret = dateFinPret;
		this.etat = etat;
		this.idOuvrage = idOuvrage;
		this.idUtilisateur = idUtilisateur;
		this.prolongation = prolongation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebutPret() {
		return dateDebutPret;
	}

	public void setDateDebutPret(Date dateDebutPret) {
		this.dateDebutPret = dateDebutPret;
	}

	public Date getDateFinPret() {
		return dateFinPret;
	}

	public void setDateFinPret(Date dateFinPret) {
		this.dateFinPret = dateFinPret;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getIdOuvrage() {
		return idOuvrage;
	}

	public void setIdOuvrage(int idOuvrage) {
		this.idOuvrage = idOuvrage;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public boolean isProlongation() {
		return prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}
	
	
}
