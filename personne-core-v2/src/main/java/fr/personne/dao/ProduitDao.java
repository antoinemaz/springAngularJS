package fr.personne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.personne.entities.ProduitEntity;

public interface ProduitDao extends JpaRepository<ProduitEntity, Integer> {


}