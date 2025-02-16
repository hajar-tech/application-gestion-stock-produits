
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
                <div>
                    <h2>
                        <c:if test="${produit != null}">
                            Edit Product
                        </c:if>
                        <c:if test="${produit == null}">
                            Add New Product
                        </c:if>
                    </h2>
                </div>

                <form action="${pageContext.request.contextPath}/${produit != null ? 'update' : 'insert'}" method="post">
    <c:if test="${produit != null}">
        <input type="hidden" name="idProduit" value="<c:out value='${produit.idProduit}' />">
    </c:if>

                    <fieldset class="form-group">
                        <label>Product Name</label> 
                        <input type="text" value="<c:out value='${produit.nameProduit}' />" class="form-control" name="nameProduit" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Description</label> 
                        <input type="text" value="<c:out value='${produit.descriptionProduit}' />" class="form-control" name="descriptionProduit">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Price</label> 
                        <input type="text" value="<c:out value='${produit.prix}' />" class="form-control" name="prix">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Quantity</label> 
                        <input type="text" value="<c:out value='${produit.quantite}' />" class="form-control" name="quantite">
                    </fieldset>

                    <label>Category:</label>
    <select name="categorie">
        <option value="Électronique" ${produit.categorie == 'Électronique' ? 'selected' : ''}>Électronique</option>
        <option value="Beauté" ${produit.categorie == 'Beauté' ? 'selected' : ''}>Beauté</option>
        <option value="Maison" ${produit.categorie == 'Maison' ? 'selected' : ''}>Maison</option>
        <option value="Vêtements" ${produit.categorie == 'Vêtements' ? 'selected' : ''}>Vêtements</option>
        <option value="Alimentation" ${produit.categorie == 'Alimentation' ? 'selected' : ''}>Alimentation</option>
    </select>
    

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
