package openFoodFacts.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import openFoodFacts.entites.Additif;
import openFoodFacts.utils.StringUtils;

public class AdditifDao {

	public AdditifDao() {

	}

	public static List<Additif> insert(String[] additif, EntityManager em) {

		List<Additif> addListe = new ArrayList<>();

		for (int i = 0; i < additif.length; i++) {

			String iStr = StringUtils.tronque(additif[i]).trim();

			if (!iStr.isEmpty()) {

				TypedQuery<Additif> query = em.createQuery("SELECT a FROM Additif a WHERE a.nom=?1", Additif.class);
				query.setParameter(1, iStr);
				List<Additif> addDaoListe = query.getResultList();

				Additif add = new Additif(iStr);
				if (addDaoListe.isEmpty()) {
					em.persist(add);
				} else {
					add = addDaoListe.get(0);
				}
				addListe.add(add);

			}
		}

		return addListe;

	}

}
