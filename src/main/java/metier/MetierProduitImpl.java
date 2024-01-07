package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetierProduits {
	@Override
	public List<Produit> getProduitsParMotCle(String mc) {
		List<Produit> prods = new ArrayList<Produit>();

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from produits where ref LIKE ? ");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("ref"));
				Produit p = new Produit();
				p.setIdProduit(rs.getLong("id"));
				p.setNomProduit(rs.getString("ref"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				prods.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
	}
}
