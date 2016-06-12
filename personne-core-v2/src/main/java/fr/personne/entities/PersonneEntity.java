package fr.personne.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.anto.entities.Entity;

@javax.persistence.Entity
@Table(name="personne")
public class PersonneEntity extends Entity {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;

	@Column(length = 100, name="nom")
	private String nom;
	
	@Column(length = 100, name="prenom")
	private String prenom;
	
	@Column(name="age")
	private int age;
	
	@OneToMany(targetEntity=ProduitEntity.class, mappedBy="personne", orphanRemoval = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ProduitEntity> produits;
	
	/**
	 * @return the produits
	 */
	public List<ProduitEntity> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	public void setProduits(List<ProduitEntity> produits) {
		this.produits = produits;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}