package openFoodFacts.utils;


//classe stateless : pas d'attributs d'instance ==> donc méthodes static
public class StringUtils {

	public static String tronque(String valeur) {
		
		String newValeur = valeur.replaceAll("[*_/]", "");
		if (newValeur.length() > 255) {
			return newValeur.substring(0, 255);
		}
		return newValeur;
	}
	
	
}