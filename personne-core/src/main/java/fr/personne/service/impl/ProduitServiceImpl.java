package fr.personne.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.anto.dao.GenericDao;
import fr.anto.service.GenericServiceImpl;
import fr.personne.dao.ProduitDao;
import fr.personne.entities.ProduitEntity;
import fr.personne.service.ProduitService;

@Service
public class ProduitServiceImpl extends GenericServiceImpl<ProduitEntity, Integer> implements ProduitService {

	private ProduitDao produitDao;
	
    @Autowired
    public ProduitServiceImpl(
            @Qualifier("produitDaoImpl") GenericDao<ProduitEntity, Integer> genericDao) {
        super(genericDao);
        this.produitDao = (ProduitDao) produitDao;
    }
}