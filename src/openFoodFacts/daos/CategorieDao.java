package openFoodFacts.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import openFoodFacts.entites.Categorie;

public class CategorieDao {
	
	public CategorieDao() {
	}

	public static Categorie insert(String nom, EntityManager em) {
		TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c WHERE c.nom=?1", Categorie.class);
		query.setParameter(1, nom);
		List<Categorie> cListe = query.getResultList();
		Categorie c = new Categorie(nom);
		if (cListe.isEmpty()) {
			em.persist(c);
		} else {
			c = cListe.get(0);
		}
		return c;
	}
	
	
}