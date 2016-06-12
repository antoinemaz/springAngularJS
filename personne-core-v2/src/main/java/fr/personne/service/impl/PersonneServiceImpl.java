package fr.personne.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.personne.dao.PersonneDao;
import fr.personne.entities.PersonneEntity;
import fr.personne.service.PersonneService;

@Service
@Transactional
public class PersonneServiceImpl implements PersonneService{

	@Autowired
	PersonneDao personneDao;

	/**
	 * @return the personneDao
	 */
	public PersonneDao getPersonneDao() {
		return personneDao;
	}

	@Override
	public JpaRepository<PersonneEntity, Integer> getDao() {
		return personneDao;
	}
}