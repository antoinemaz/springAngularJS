package fr.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.personne.entities.PersonneEntity;
import fr.personne.service.PersonneService;

@RestController
public class PersonneController {
	
	@Autowired
	PersonneService personneService;
	
	 @RequestMapping(value = "/say/{name}", method = RequestMethod.GET)
	 public String sayHello(@PathVariable String name) {
		 String result="Salut "+name;
		 personneService.getDao().findAll();
		 return result;
	 }
	 
	 @RequestMapping(value = "/personnes/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	 public ResponseEntity<String> addPersonne(@RequestBody PersonneEntity personne) {
		 
		 if(!personne.getNom().isEmpty() && !personne.getPrenom().isEmpty() && personne.getAge() > 18){
			personneService.getDao().save(personne);
			return new ResponseEntity<String>("", HttpStatus.CREATED);
		 }else{
			 return new ResponseEntity<String>("Problèmes de données d'entrées (message du serveur)", HttpStatus.NOT_ACCEPTABLE);
		 }
	 }
	 
	 @RequestMapping("/personnes")
	 public ResponseEntity<List<PersonneEntity>> getPersonnes() {
		 
		 List<PersonneEntity> personnes = personneService.getDao().findAll();
		 
		 return new ResponseEntity<List<PersonneEntity>>(personnes, HttpStatus.OK);
	 }
}