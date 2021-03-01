package openFoodFacts.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import openFoodFacts.daos.AbstractDao;
import openFoodFacts.daos.AdditifDao;
import openFoodFacts.daos.AllergeneDao;
import openFoodFacts.daos.CategorieDao;
import openFoodFacts.daos.IngredientDao;
import openFoodFacts.daos.MarqueDao;
import openFoodFacts.daos.ProduitDao;
import openFoodFacts.entites.Additif;
import openFoodFacts.entites.Allergene;
import openFoodFacts.entites.Categorie;
import openFoodFacts.entites.Ingredient;
import openFoodFacts.entites.Marque;
import openFoodFacts.entites.Produit;

public class ParseurLigne extends AbstractDao {

	public static void ajout(String ligne){
		
		// split de la ligne selon delimiter |
	
		String[] decoupage = ligne.split("\\|",-1);
		String categorie = StringUtils.tronque(decoupage[0]);
		String marque = StringUtils.tronque(decoupage[1]);
		String nom = StringUtils.tronque(decoupage[2]);
		String grade = decoupage[3];
		String[] ingredients = decoupage[4].split("[;,]", -1);
		float energie = FloatUtils.parse(decoupage[5]);
		float graisse = FloatUtils.parse(decoupage[6]);
		float sucres = FloatUtils.parse(decoupage[7]);
		float fibres = FloatUtils.parse(decoupage[8]);
		float proteines = FloatUtils.parse(decoupage[9]);
		float sel = FloatUtils.parse(decoupage[10]);
		String[] allergenes = decoupage[28].split("[;,]", -1);
		String[] additifs = decoupage[29].split("[;,]", -1);
		
		// instance du mode transaction pour chaque ligne lue du fichier CSV
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		// intégration des éléments si inextistant
		
		Categorie c = CategorieDao.insert(categorie, em);
		Marque m = MarqueDao.insert(marque, em);
		List<Ingredient> ingListe = IngredientDao.insert(ingredients, em);		
		List<Additif> addListe = AdditifDao.insert(additifs, em);
		List<Allergene> allListe = AllergeneDao.insert(allergenes, em);
		Produit p = new Produit(nom, grade, energie, graisse, sucres, fibres, proteines, sel, c, m, ingListe, addListe, allListe);
		ProduitDao.insert(nom, p, em);
		
		// Fermeture de la transaction
		
		transaction.commit();
			
	}
}
