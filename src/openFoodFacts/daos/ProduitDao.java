package openFoodFacts.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import openFoodFacts.entites.Produit;

public class ProduitDao{
	
	public ProduitDao() {

	}
	
	public static void insert(String nom, Produit p, EntityManager em) {
		TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p WHERE p.nom=?1", Produit.class);
		query.setParameter(1, nom);
		List<Produit> pListe = query.getResultList();
		if (pListe.isEmpty()) {
			em.persist(p);
		}
	}
	
	
}
