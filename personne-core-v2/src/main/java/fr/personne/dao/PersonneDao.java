package fr.personne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.personne.entities.PersonneEntity;

public interface PersonneDao extends JpaRepository<PersonneEntity, Integer> {


}