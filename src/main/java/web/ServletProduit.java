package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import metier.Produit;
import dao.IProduitDAO;
import dao.ProduitDAOImp;

@SuppressWarnings("unused")
@WebServlet(name = "cs", urlPatterns = { "/liste", "*.do" })
public class ServletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IProduitDAO metier;

	@Override
	public void init() throws ServletException {
		metier = new ProduitDAOImp();
	}

	public ServletProduit() {
		super();
	}

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		if ("/liste".equals(path)) {
			ProduitModele model = this.prepareModel("");
			request.setAttribute("model", model);
			this.forwardToJSP(request, response, "/WEB-INF/produits.jsp");
		} else if ("/chercher.do".equals(path)) {
			ProduitModele searchModel = this.prepareModel(request.getParameter("motCle"));
			request.setAttribute("model", searchModel);
			this.forwardToJSP(request, response, "/WEB-INF/produits.jsp");
		} else if ("/saisie.do".equals(path) || "/save.do".equals(path)) {
			this.forwardToJSP(request, response, "/WEB-INF/Ajouter.jsp");
		} else if ("/supprimer.do".equals(path)) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				metier.deleteProduit(id);
				response.sendRedirect("liste");
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
			}
		} else if ("/editer.do".equals(path)) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				Produit p = metier.getProduit(id);
				request.setAttribute("produit", p);
				this.forwardToJSP(request, response, "/WEB-INF/editerProduit.jsp");
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
			}
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid path");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/save.do")) {
			try {
				String nom = request.getParameter("nom");
				double prix = Double.parseDouble(request.getParameter("prix"));
				int quantite = Integer.parseInt(request.getParameter("quantite"));
				Produit p = metier.save(new Produit(nom, prix, quantite));
				request.setAttribute("produit", p);
				this.forwardToJSP(request, response, "/WEB-INF/confirmation.jsp");
//				this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
			}
		} else if (request.getServletPath().equals("/update.do")) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				String nom = request.getParameter("nom");
				double prix = Double.parseDouble(request.getParameter("prix"));
				int quantite = Integer.parseInt(request.getParameter("quantite"));
				Produit p = new Produit(nom, prix, quantite);
				p.setIdProduit(id);
				metier.updateProduit(p);
				request.setAttribute("produit", p);
				this.forwardToJSP(request, response, "/WEB-INF/confirmation.jsp");
//				this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
			}
		}
	}

	private ProduitModele prepareModel(String motCle) {
		ProduitModele model = new ProduitModele();
		model.setMotCle(motCle);
		List<Produit> prods = metier.produitsParMC(motCle);
		model.setProduits(prods);
		return model;
	}

	private void forwardToJSP(HttpServletRequest request, HttpServletResponse response, String jspPage)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(jspPage).forward(request, response);
	}
}
