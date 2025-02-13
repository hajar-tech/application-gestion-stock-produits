package stockageManagement.model;

import java.math.BigDecimal;

public class Produit {
	private int idProduit;
	private String nameProduit;
	private String descriptionProduit;
	private BigDecimal prix;
	private int quantite;
	private Categorie categorie;
	
	//declaration d'une enum categorie
	public enum Categorie {
		Électronique, Beauté, Maison, Vêtements, Alimentation
		
	}
	
	//creation des constructeur
	public Produit() {}
	
	
	
	public Produit(int id, String nameProduit, String descriptionProduit, BigDecimal prix, int quantite, Categorie categorie) {
		super();
		this.idProduit = id;
		this.nameProduit = nameProduit;
		this.descriptionProduit = descriptionProduit;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
	}

   

	public Produit(String nameProduit, String description, BigDecimal prix, int quantite, Categorie categorie) {
		super();
		this.nameProduit = nameProduit;
		this.descriptionProduit = description;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
	}



	//getters and setters 
	public int getId() {
		return idProduit;
	}

	public void setId(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nameProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nameProduit = nomProduit;
	}

	public String getDescription() {
		return descriptionProduit;
	}

	public void setDescription(String description) {
		this.descriptionProduit = description;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	};
	
	
	

}
