package openFoodFacts;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;

import openFoodFacts.utils.ParseurLigne;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws InterruptedException {
		
		String filePath = "target/classes/open-food-facts.csv";

		try {
			
			// Compteur de temps de traitement
			
			Calendar calDebut = Calendar.getInstance();
			long debut = calDebut.getTimeInMillis();
			
			// Lecture du fichier et traitement par ligne
			
			File file = new File(filePath);
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			int nbLigne = 0;
			for (int i = 1; i < lignes.size(); i++) {
				String ligne = lignes.get(i);
				ParseurLigne.ajout(ligne);
				nbLigne++;
				System.err.println("Ligne " + (i+1) + " du tableau Excel enregistrée.");
			}
			
			// Durée de traitement
			
			System.out.println("-------------------------------------------------------------------");
			System.out.print("Traitement de " + nbLigne + " lignes");
			Calendar calFin = Calendar.getInstance();
			long fin = calFin.getTimeInMillis();
			int dureeSec = (int)(fin-debut)/1000;
			if (dureeSec >= 60) {
				System.out.println(" effectué en " + dureeSec/60 + " minutes et " + dureeSec%60 + " secondes.");
			} else {
				System.out.println(" effectué en " + dureeSec + " secondes.");
			}
			System.out.println("-------------------------------------------------------------------");
			
			// jet n°1 : Traitement de 13432 lignes effectué en 24 minutes et 25 secondes.
			// jet n°2 : Traitement de 13432 lignes effectué en 19 minutes et 12 secondes. (1 Transaction par ligne)
			// jet n°3 : Traitement de 13432 lignes effectué en 17 minutes et 19 secondes. (Float et Short)
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
