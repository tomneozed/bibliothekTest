package com.DAO.pojo;

import org.hibernate.search.annotations.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name="auteur")
@Table(name="auteur")
public class AuteurPojo implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="auteur_gen")
	private int id;
	
	@Field
	private String nom;
	
	@Field
	private String prenom;
	
	@Column(name="date_naissance")
	private Date dateNaissance;
	
	@Column(name="date_deces")
	private Date dateDeces;

	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinTable(name="auteur_ouvrage", joinColumns= @JoinColumn(name="id_auteur"), inverseJoinColumns = @JoinColumn(name="id_ouvrage"))
	//private List<OuvragePojo> ouvragesPojos = new ArrayList<OuvragePojo>();
		
	public AuteurPojo(int id, String nom, String prenom, Date dateNaissance, Date dateDeces) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.dateDeces = dateDeces;
	}
	
	public AuteurPojo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}
}
