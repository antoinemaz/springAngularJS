package fr.personne.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.anto.dao.GenericDao;
import fr.anto.service.GenericServiceImpl;
import fr.personne.dao.PersonneDao;
import fr.personne.entities.PersonneEntity;
import fr.personne.service.PersonneService;

@Service
public class PersonneServiceImpl extends GenericServiceImpl<PersonneEntity, Integer> implements PersonneService {

	private PersonneDao personneDao;
	
    @Autowired
    public PersonneServiceImpl(
            @Qualifier("personneDaoImpl") GenericDao<PersonneEntity, Integer> genericDao) {
        super(genericDao);
        this.personneDao = (PersonneDao) genericDao;
    }
}