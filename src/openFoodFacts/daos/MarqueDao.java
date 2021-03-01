package openFoodFacts.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import openFoodFacts.entites.Marque;

public class MarqueDao {
	
	public MarqueDao() {
	}

	public static Marque insert(String nom, EntityManager em) {
		TypedQuery<Marque> query = em.createQuery("SELECT m FROM Marque m WHERE m.nom=?1", Marque.class);
		query.setParameter(1, nom);
		List<Marque> mListe = query.getResultList();
		Marque m = new Marque(nom);
		if (mListe.isEmpty()) {
			em.persist(m);
		} else {
			m = mListe.get(0);
		}
		return m;
	}
	
	
}

