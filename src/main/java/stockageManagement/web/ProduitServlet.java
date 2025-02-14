package stockageManagement.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dtockageManagement.dao.ProduitDao;
import stockageManagement.model.Produit;
import stockageManagement.model.Produit.Categorie;

/**
 * Servlet implementation class ProduitServlet
 * @param <BigDecimal>
 */
@WebServlet("/")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDao produitDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
    	this.produitDao = new ProduitDao();
       
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/new" : 
			showNewForm(request, response);
			break;
		case "/insert" : 
			try {
				insertProduit(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete" :
			try {
				deleteProduit(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit" : 
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update" : 
			try {
				updateProduit(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		default:
			try {
				listProduit(request , response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
	}
	 private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher("produit-form.jsp");
			        dispatcher.forward(request, response);
	 }
	 
	 
	 private void insertProduit(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String nameProduit = request.getParameter("nameProduit");
			        String descriptionProduit = request.getParameter("descriptionProduit");
			        BigDecimal prix = new BigDecimal(request.getParameter("prix"));//Cela convertit la valeur String en BigDecimal
			        int quantite = Integer.parseInt(request.getParameter("quantite"));// covetrir la valeur string en int 
			        Categorie categorie = Categorie.valueOf(request.getParameter("categorie")) ;
			        Produit newProduit = new Produit(nameProduit, descriptionProduit, prix, quantite,categorie );
			        produitDao.insertProduit(newProduit);
			        response.sendRedirect("list");
			    }

	 
	  private void deleteProduit(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("idProduit"));
			        produitDao.deleteProduit(id);
			        response.sendRedirect("list");

			    }
	  
	  
	  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int id = Integer.parseInt(request.getParameter("idProduit"));
			        Produit existingUser = produitDao.selectProduit(id);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("produit-form.jsp");
			        request.setAttribute("produit", existingUser);
			        dispatcher.forward(request, response);

			    }
	  
	  private void updateProduit(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("idProuit"));
			        String nameProduit = request.getParameter("nameProduit");
			        String descriptionProduit = request.getParameter("descriptionProduit");
			        BigDecimal prix = new BigDecimal(request.getParameter("prix"));//Cela convertit la valeur String en BigDecimal
			        int quantite = Integer.parseInt(request.getParameter("quantite"));// covetrir la valeur string en int 
			        Categorie categorie = Categorie.valueOf(request.getParameter("categorie")) ;
			        Produit produit = new Produit(id,nameProduit, descriptionProduit, prix, quantite,categorie );

		
			        produitDao.updateProduit(produit);
			        response.sendRedirect("list");
			    }
	  
	  
	  private void listProduit(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Produit > listProduit = produitDao.selectAllProduits();
			        request.setAttribute("listProduit", listProduit);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("produit-list.jsp");
			        dispatcher.forward(request, response);
			    }
	
}
