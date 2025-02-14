<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>


<head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
</head>
<body>

           <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand"> Product Management </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Products</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${produit != null}">
                            <form action="update" method="post"></form>
                        </c:if>
                        <c:if test="${produit == null}">
                            <form action="insert" method="post"></form>
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${produit != null}">
                                    Edit User
                                </c:if>
                                <c:if test="${produit == null}">
                                    Add New User
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${produit != null}">
                            <input type="hidden" name="id" value="<c:out value='${produit.idProduit}' />" />
                        </c:if>
        <form action="">
                        <fieldset class="form-group">
                            <label>Product Name</label> <input type="text" value="<c:out value='${produit.nameProduit}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Product Description</label> <input type="text" value="<c:out value='${produit.descriptionProduit}' />" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Product price</label> <input type="text" value="<c:out value='${produit.prix}' />" class="form-control" name="country">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Product quantity</label> <input type="text" value="<c:out value='${produit.quantite}' />" class="form-control" name="country">
                        </fieldset>
                        
                        <fieldset class="form-group">
  						  <label for="category">Product Category</label>
  <!--<input type="text" value="<c:out value='${product.category}' />" class="form-control" name="category" id="category">-->

   							<select class="form-select mt-2" aria-label="Select category" name="category" id="category">
   							 <option value="" ${empty product.categorie ? '' : ''}>Choose a category</option>
    						<option value="1" ${product.categorie == '1' ? 'Électronique' : ''}>Électronique</option>
    						<option value="1" ${product.categorie == '1' ? 'Beauté' : ''}>Beauté</option>
   	 						<option value="2" ${product.categorie == '2' ? 'Maison' : ''}>Maison</option>
    						<option value="3" ${product.categorie == '3' ? 'Vêtements' : ''}>Vêtements</option>
    						<option value="4" ${product.categorie == '3' ? 'Alimentation' : ''}>Alimentation</option>
							</select>
						</fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
       

</body>
</html>