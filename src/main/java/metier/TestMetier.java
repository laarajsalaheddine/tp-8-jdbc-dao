package metier;

import java.util.List;

public class TestMetier {
	public static void main(String[] args) {
		MetierProduitImpl metier= new MetierProduitImpl();
		List<Produit> prods = metier.getProduitsParMotCle("HP");
		for (Produit p :prods)
			System.out .println(p.getNomProduit());
		}

}
