package metier;

public class Produit {
	private Long idProduit;
	private String nomProduit;
	private double prix;
	private int quantite;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(String nomProduit, double prix, int quantite) {
		super();
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.quantite = quantite;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {

		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;

	}

	public void setQuantite(int quantite) {

		this.quantite = quantite;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
}
