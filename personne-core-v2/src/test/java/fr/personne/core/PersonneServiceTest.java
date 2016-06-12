package fr.personne.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.personne.entities.PersonneEntity;
import fr.personne.entities.ProduitEntity;
import fr.personne.service.PersonneService;
import fr.personne.service.ProduitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring_test.xml")
public class PersonneServiceTest {

  @Autowired
  private PersonneService personneService;
  
  @Autowired
  private ProduitService produitService;
	
  
  @Before
  public void before(){
	  
	  // Personne
	  PersonneEntity personne = new PersonneEntity();
	  personne.setNom("MAZ");
	  personne.setPrenom("Antoine");
	  personne.setAge(25);
	  
	  personne = personneService.getDao().save(personne);
	  
	  Assert.assertEquals(1, personneService.getDao().findOne(1).getId());
	  Assert.assertEquals(0, personneService.getDao().findOne(1).getProduits().size());
	  Assert.assertEquals(1, personneService.getDao().findAll().size());
	  
	  // Produits
	  List<ProduitEntity> produits = new ArrayList<ProduitEntity>();
	  
	  ProduitEntity p1 = new ProduitEntity();
	  p1.setNom("PRODUIT 1");
	  p1.setPersonne(personne);
	  
	  ProduitEntity p2 = new ProduitEntity();
	  p2.setNom("PRODUIT 2");
	  p2.setPersonne(personne);
	  
	  produits.add(p1);
	  produits.add(p2);
	  
	  personne.setNom("MAZ MODIFIE");
	  personne.setProduits(produits);
	  
	  personne = personneService.getDao().save(personne);
	  
	  produitService.getDao().findAll();
	  
	  Assert.assertEquals(1, personneService.getDao().findOne(1).getId());
	  Assert.assertEquals("MAZ MODIFIE", personneService.getDao().findOne(1).getNom());
	  Assert.assertEquals(2, personneService.getDao().findOne(1).getProduits().size());
	  Assert.assertEquals(1, personneService.getDao().findAll().size());
	  
  }
  
	@Test
	public void testGetAll() {
		
		List<PersonneEntity> personnes = personneService.getDao().findAll();
		
		Assert.assertFalse(personnes.isEmpty());
		Assert.assertTrue(personnes.size() == 1);
		Assert.assertTrue(personnes.stream().anyMatch(p -> p.getNom().contains("MAZ")));
	}
}