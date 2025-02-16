<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Product Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
            </head>
        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand"> Product
     Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Products</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Products</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New Product</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>description</th>
                                <th>prix</th>
                                <th>qantite</th>
                                <th>categorie</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="produit" items="${listProduit}">

                                <tr>
                                    <td>
                                        <c:out value="${produit.idProduit}" />
                                    </td>
                                    <td>
                                        <c:out value="${produit.nameProduit}" />
                                    </td>
                                    <td>
                                        <c:out value="${produit.descriptionProduit}" />
                                    </td>
                                    <td>
                                        <c:out value="${produit.prix}" />
                                    </td>
                                     <td>
                                        <c:out value="${produit.quantite}" />
                                    </td>
                                     <td>
                                        <c:out value="${produit.categorie}" />
                                    </td>
                                    <td><a href="edit?idProduit=<c:out value='${produit.idProduit}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?idProduit=<c:out value='${produit.idProduit}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>