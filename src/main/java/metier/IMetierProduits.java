package metier;
import java.util.List;

public interface IMetierProduits {

	public List<Produit> getProduitsParMotCle(String mc);
	public void addProduit(Produit p);
}
