package openFoodFacts.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import openFoodFacts.entites.Allergene;
import openFoodFacts.utils.StringUtils;

public class AllergeneDao {

	public AllergeneDao() {

	}

	public static List<Allergene> insert(String[] allergene, EntityManager em) {

		List<Allergene> allListe = new ArrayList<>();

		for (int i = 0; i < allergene.length; i++) {

			String iStr = StringUtils.tronque(allergene[i]).trim();

			if (!iStr.isEmpty()) {

				TypedQuery<Allergene> query = em.createQuery("SELECT a FROM Allergene a WHERE a.nom=?1",
						Allergene.class);
				query.setParameter(1, iStr);
				List<Allergene> allDaoListe = query.getResultList();

				Allergene all = new Allergene(iStr);

				if (allDaoListe.isEmpty()) {
					em.persist(all);
				} else {
					all = allDaoListe.get(0);
				}

				allListe.add(all);
				
			}
		}

		return allListe;
	}

}