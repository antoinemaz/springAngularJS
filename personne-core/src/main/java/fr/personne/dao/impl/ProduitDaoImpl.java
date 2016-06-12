package fr.personne.dao.impl;

import org.springframework.stereotype.Repository;

import fr.anto.dao.GenericDaoImpl;
import fr.personne.dao.ProduitDao;
import fr.personne.entities.ProduitEntity;

@Repository
public class ProduitDaoImpl extends GenericDaoImpl<ProduitEntity, Integer> implements ProduitDao{

}