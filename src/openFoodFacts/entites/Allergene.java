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
import javax.persistence.Table;

@Entity
@Table(name="Allergene")
public class Allergene {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name="NOM", length = 255, nullable = true)
	private String nom;
	
	@ManyToMany
	@JoinTable(name="ALL_PRO", joinColumns= @JoinColumn(name="ID_ALL", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_PRO", referencedColumnName="ID"))
	private List<Produit> produits = new ArrayList<>();

	public Allergene() {
		
	}

	public Allergene(String nom) {
		this.nom = nom;
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
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	

}
