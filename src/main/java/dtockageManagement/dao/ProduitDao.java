package dtockageManagement.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stockageManagement.model.Produit;
import stockageManagement.model.Produit.Categorie;

public class ProduitDao {
	
	//creation des variables pour la connexion
	private String jdbcUrl = "jdbc:mysql://localhost:3306/stockmanagement";
	private String jdbcUserName= "root";
	private String jdbcPassWord ="root2002";
	
	
	 private static final String INSERT_PRODUITS_SQL ="INSERT INTO produits (nameProduit, descriptionProduit, prix, quantite, categorie) VALUES (?, ?, ?, ?, ?)";
		    private static final String SELECT_PRODUITS_BY_ID = "select idProduit,nameProduit,descriptionProduit,prix,quantite,categorie from produits where idProduit =?";
		    private static final String SELECT_ALL_PRODUITS = "select * from produits";
		    private static final String DELETE_PRODUITS_SQL = "delete from produits where idProduit = ?;";
		    private static final String UPDATE_PRODUITS_SQL = "update produits set nameProduit = ?,descriptionProduit = ?, prix = ?,quantite = ?,categorie = ? where idProduit = ?;";

	//fonction getConnection pour la connection avec database
		    protected Connection getConnection() {
		        Connection connection = null;
		        try {
		        	Class.forName("com.mysql.jdbc.Driver");
		            connection = DriverManager.getConnection(jdbcUrl,jdbcUserName,jdbcPassWord);
		            connection.setAutoCommit(true);
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return connection;
		        
		    }
		    
		    
      //codage du CRUD
	//créer ou ajouter un produit
		    public void insertProduit (Produit produit) throws SQLException {
		    	try(Connection connection = getConnection();
		    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUITS_SQL)
		    			){
		    		preparedStatement.setString(1, produit.getNomProduit());
		    		preparedStatement.setString(2, produit.getDescription());
		    		preparedStatement.setBigDecimal(3, produit.getPrix());
		    		preparedStatement.setInt(4, produit.getQuantite());
		    		preparedStatement.setString(5, produit.getCategorie().name());
		    		preparedStatement.executeUpdate();
		    	}catch (Exception e) {
		    		e.printStackTrace();
		    		
		    	}
		    }
	//modifier les infos d'un produit
		    public boolean updateProduit (Produit produit) throws SQLException {
		    	boolean rowUpdated;
		    	try(Connection connection = getConnection();
		    			PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUITS_SQL)
		    			){
		    		statement.setString(1, produit.getNomProduit());
		    		statement.setString(2, produit.getDescription());
		    		statement.setBigDecimal(3, produit.getPrix());
		    		statement.setInt(4, produit.getQuantite());
		    		statement.setString(5, produit.getCategorie().name());
		    		statement.setInt(6, produit.getId());
		    		rowUpdated = statement.executeUpdate()>0;
		    	}return rowUpdated;
		    }
	//selectioner un produit par son id
		    public Produit selectProduit(int idProduit) {
		        Produit produit = null;
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUITS_BY_ID );) {
		            preparedStatement.setInt(1, idProduit);
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                String nom = rs.getString("nameProduit");
		                String description = rs.getString("descriptionProduit");
		                BigDecimal prix = rs.getBigDecimal("prix");
		                int quantite = rs.getInt("quantite");
		                Categorie categorie = Categorie.valueOf(rs.getString("categorie"));// récupérer la valeur sous forme de String et la convertir en enum
		                produit = new Produit( idProduit, nom, description, prix, quantite, categorie);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return produit;
		    }
	//selectionner tous les produits
		    public List<Produit> selectAllProduits() {
		       List<Produit> produits = new ArrayList<>();
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUITS );) {
		          
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		            	int idProduit = rs.getInt("idProduit");
		                String nom = rs.getString("nameProduit");
		                String description = rs.getString("descriptionProduit");
		                BigDecimal prix = rs.getBigDecimal("prix");
		                int quantite = rs.getInt("quantite");
		                Categorie categorie = Categorie.valueOf(rs.getString("categorie"));// récupérer la valeur sous forme de String et la convertir en enum
		               produits.add(new Produit( idProduit, nom, description, prix, quantite, categorie));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return produits;
		    }
    //suuprimer un produits	
		    
		    public boolean deleteProduit(int id) throws SQLException {
		        boolean rowDeleted;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUITS_SQL);) {
		            statement.setInt(1, id);
		            rowDeleted = statement.executeUpdate() > 0;
		        }
		        return rowDeleted;
		    }
		    
		    
		   
}

