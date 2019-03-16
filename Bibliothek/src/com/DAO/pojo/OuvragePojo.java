package com.DAO.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;


@Entity(name="ouvrage")
@Table(name="ouvrage")
public class OuvragePojo implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ouvrage_gen")
	//@SequenceGenerator(name="ouvrage_gen", sequenceName="ouvrage_id_seq", schema="public")
	private int id;
	
	//@Field(index=org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String titre;
	
	//@Field(index=org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String editeur;
	
	private String nature;
	
	private String resume;
	
	@Column(name="nombre_pages")
	private int nombrePages;
	
	@Column(name="date_parution")
	private Date dateParution; 
	
	private double prix;
	
	@Column(name="nombre_exemplaires")
	private int nombreExemplaires;
	
	@Column(name="nombre_exemplaires_dispo")
	private int nombreExemplairesDispo;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(
//			name="auteur_ouvrage", 
//			joinColumns=@JoinColumn(name="id_ouvrage"),
//			inverseJoinColumns=@JoinColumn(name="id_auteur"))
//	private List<AuteurPojo> auteurs = new ArrayList<AuteurPojo>();
		
	public OuvragePojo() {
		
	}

	public OuvragePojo(int id, String titre, String editeur, String nature, String resume, int nombrePages,
			Date dateParution, double prix, int nombreExemplaires, int nombreExemplairesDispo) {
		super();
		this.id = id;
		this.titre = titre;
		this.editeur = editeur;
		this.nature = nature;
		this.resume = resume;
		this.nombrePages = nombrePages;
		this.dateParution = dateParution;
		this.prix = prix;
		this.nombreExemplaires = nombreExemplaires;
		this.nombreExemplairesDispo = nombreExemplairesDispo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getNombrePages() {
		return nombrePages;
	}

	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getNombreExemplaires() {
		return nombreExemplaires;
	}

	public void setNombreExemplaires(int nombreExemplaires) {
		this.nombreExemplaires = nombreExemplaires;
	}

	public int getNombreExemplairesDispo() {
		return nombreExemplairesDispo;
	}

	public void setNombreExemplairesDispo(int nombreExemplairesDispo) {
		this.nombreExemplairesDispo = nombreExemplairesDispo;
	}
	
	
}
