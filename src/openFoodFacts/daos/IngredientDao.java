package openFoodFacts.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import openFoodFacts.entites.Ingredient;
import openFoodFacts.utils.StringUtils;

public class IngredientDao {

	public IngredientDao() {

	}

	public static List<Ingredient> insert(String[] ingredients, EntityManager em) {

		List<Ingredient> ingListe = new ArrayList<>();

		for (int i = 0; i < ingredients.length; i++) {

			String iStr = StringUtils.tronque(ingredients[i]).trim();

			if (!iStr.isEmpty()) {

				TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom=?1",
						Ingredient.class);
				query.setParameter(1, iStr);
				List<Ingredient> ingDaoListe = query.getResultList();

				Ingredient ing = new Ingredient(iStr);

				if (ingDaoListe.isEmpty()) {
					em.persist(ing);
				} else {
					ing = ingDaoListe.get(0);
				}

				ingListe.add(ing);

			}
		}

		return ingListe;

	}

}
