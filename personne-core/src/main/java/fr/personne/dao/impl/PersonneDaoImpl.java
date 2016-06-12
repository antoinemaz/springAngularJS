package fr.personne.dao.impl;

import org.springframework.stereotype.Repository;

import fr.anto.dao.GenericDaoImpl;
import fr.personne.dao.PersonneDao;
import fr.personne.entities.PersonneEntity;

@Repository
public class PersonneDaoImpl extends GenericDaoImpl<PersonneEntity, Integer> implements PersonneDao{

}