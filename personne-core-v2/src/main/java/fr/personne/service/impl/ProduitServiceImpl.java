package fr.personne.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.personne.dao.ProduitDao;
import fr.personne.entities.ProduitEntity;
import fr.personne.service.ProduitService;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService  {
	
	@Autowired
	private ProduitDao produitDao;

	@Override
	public JpaRepository<ProduitEntity, Integer> getDao() {
		return this.produitDao;
	}

}