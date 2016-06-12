package fr.personnes.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

import fr.personne.dao.PersonneDao;
import fr.personne.entities.PersonneEntity;
import fr.personne.service.impl.PersonneServiceImpl;

@ManagedBean(name="personneBean")
@ViewScoped
public class PersonneBean implements Serializable {
	
	@Autowired
	PersonneDao personneDao;
	
	@Autowired
	PersonneServiceImpl personneService;
	
	PersonneEntity personne;

	@PostConstruct
	public void init(){
		FacesContextUtils
        .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
        .getAutowireCapableBeanFactory().autowireBean(this);
		// Si on ne veut pas instancier chaque bean au démarrage, voir le mode Lazy loading de Spring
		personneDao.findAll();
		
		personneService.getPersonneDao().findAll();
		
		personne = new PersonneEntity();
		
	}
	 
	public void save(){
		personneDao.save(personne);
		personne = new PersonneEntity();
	}
	
	/**
	 * @return the personneService
	 */
	public PersonneDao getPersonneDao() {
		return personneDao;
	}
	
	/**
	 * @param personneService the personneService to set
	 */
	public void setPersonneDao(PersonneDao personneDao) {
		this.personneDao = personneDao;
	}
	
	/**
	 * @return the personne
	 */
	public PersonneEntity getPersonne() {
		return personne;
	}

	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(PersonneEntity personne) {
		this.personne = personne;
	}
}