package fr.personne.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.anto.entities.Entity;

@javax.persistence.Entity
@Table(name="produit")
public class ProduitEntity extends Entity {
	
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;

	@Column(length = 100, name="nom")
	private String nom;
	
    @ManyToOne
    @JoinColumn(name = "personne_id")
	private PersonneEntity personne;
	
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
    public PersonneEntity getPersonne() {
        return personne;
    }
}