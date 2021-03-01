package openFoodFacts.utils;

// classe stateless : pas d'attributs d'instance ==> donc méthodes static
public class FloatUtils {

	public static float parse(String valeur) {
		if (valeur.isEmpty()) {
			return 0.0F;
		} else {
			float d = Float.parseFloat(valeur);
			float result = (float) Math.round(d * 100) / 100;
			return result;
		}
	}
}
