package openFoodFacts.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name="NOM", length = 255, nullable = true)
	private String nom;
	
	@Column(name="GRADE", length = 255, nullable = true)
	private String nutritionGradeFr;
	
	@Column(name = "ENERGIE", length = 10, nullable = true)
	private float energie100g;
	
	@Column(name = "GRAISSE", length = 10, nullable = true)
	private float graisse100g;
	
	@Column(name = "SUCRES", length = 10, nullable = true)
	private float sucres100g;
	
	@Column(name = "FIBRES", length = 10, nullable = true)
	private float fibres100g;
	
	@Column(name = "PROTEINES", length = 10, nullable = true)
	private float proteines100g;
	
	@Column(name = "SEL", length = 10, nullable = true)
	private float sel100g;

	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="marque_id")
	private Marque marque;
	
	@ManyToMany
	@JoinTable(name="ING_PRO", joinColumns= @JoinColumn(name="ID_PRO", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_ING", referencedColumnName="ID"))
	private List<Ingredient> ingredients = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="ADD_PRO", joinColumns= @JoinColumn(name="ID_PRO", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_ADD", referencedColumnName="ID"))
	private List<Additif> additifs = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="ALL_PRO", joinColumns= @JoinColumn(name="ID_PRO", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_ALL", referencedColumnName="ID"))
	private List<Allergene> allergenes = new ArrayList<>();

	public Produit() {	
	}
	
	public Produit(String nom, String nutritionGradeFr, float energie100g, float graisse100g, float sucres100g,
			float fibres100g, float proteines100g, float sel100g, Categorie categorie, Marque marque,
			List<Ingredient> ingredients, List<Additif> additifs, List<Allergene> allergenes) {
		this.nom = nom;
		this.nutritionGradeFr = nutritionGradeFr;
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteines100g = proteines100g;
		this.sel100g = sel100g;
		this.categorie = categorie;
		this.marque = marque;
		this.ingredients = ingredients;
		this.additifs = additifs;
		this.allergenes = allergenes;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", nutritionGradeFr=" + nutritionGradeFr + ", energie100g=" + energie100g
				+ ", graisse100g=" + graisse100g + ", sucres100g=" + sucres100g + ", fibres100g=" + fibres100g
				+ ", proteines100g=" + proteines100g + ", sel100g=" + sel100g + "]";
	}

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the nutritionGradeFr
	 */
	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	/**
	 * @param nutritionGradeFr the nutritionGradeFr to set
	 */
	public void setNutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}

	/**
	 * @return the energie100g
	 */
	public double getEnergie100g() {
		return energie100g;
	}

	/**
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(float energie100g) {
		this.energie100g = energie100g;
	}

	/**
	 * @return the graisse100g
	 */
	public double getGraisse100g() {
		return graisse100g;
	}

	/**
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(float graisse100g) {
		this.graisse100g = graisse100g;
	}

	/**
	 * @return the sucres100g
	 */
	public double getSucres100g() {
		return sucres100g;
	}

	/**
	 * @param sucres100g the sucres100g to set
	 */
	public void setSucres100g(float sucres100g) {
		this.sucres100g = sucres100g;
	}

	/**
	 * @return the fibres100g
	 */
	public double getFibres100g() {
		return fibres100g;
	}

	/**
	 * @param fibres100g the fibres100g to set
	 */
	public void setFibres100g(float fibres100g) {
		this.fibres100g = fibres100g;
	}

	/**
	 * @return the proteines100g
	 */
	public double getProteines100g() {
		return proteines100g;
	}

	/**
	 * @param proteines100g the proteines100g to set
	 */
	public void setProteines100g(float proteines100g) {
		this.proteines100g = proteines100g;
	}

	/**
	 * @return the sel100g
	 */
	public double getSel100g() {
		return sel100g;
	}

	/**
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(float sel100g) {
		this.sel100g = sel100g;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the additifs
	 */
	public List<Additif> getAdditifs() {
		return additifs;
	}

	/**
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

	/**
	 * @return the allergenes
	 */
	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	/**
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}
	
	
	
}
