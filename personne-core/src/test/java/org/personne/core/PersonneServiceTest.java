package org.personne.core;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.personne.entities.PersonneEntity;
import fr.personne.service.PersonneService;

@ActiveProfiles(profiles = "test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class PersonneServiceTest  {

	@Autowired
    private PersonneService personneService;
	
	
  @Autowired
  DataSource dataSource;
	
  @Before
  public void before() {
	  PersonneEntity personne = new PersonneEntity();
	  personne.setNom("MAZ");
	  personne.setPrenom("Antoine");
	  personne.setAge(25);
	  personneService.add(personne);
  }

	@Test
	public void testGetAll() {
		
		List<PersonneEntity> personnes = personneService.getAll();
		Assert.assertFalse(personnes.isEmpty());
		Assert.assertTrue(personnes.size() == 1);
		Assert.assertTrue(personnes.stream().anyMatch(p -> p.getNom().equals("MAZ")));
	}
}