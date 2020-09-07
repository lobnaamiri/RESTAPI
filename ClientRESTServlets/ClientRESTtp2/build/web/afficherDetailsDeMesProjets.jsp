<%-- 
    Document   : afficherDetailsDeMesProjets
    Created on : 2020-08-09, 17:38:42
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <table border="2">
            <tr>
                <th> Id projet :</th>
                <th> Nom du projet :</th>
                <th> Description :</th>
                <th> Nom de la personne :</th>
                <th> Id de la personne :</th>
                <th>Supprimer membre</th>
            </tr>
            <c:forEach var="detailsProjet" items="${Details}">
                <tr>   
                    <td><c:out value = "${detailsProjet.idprojet}" /></td> 
                    <td><c:out value = "${detailsProjet.nomProjet}" /></td> 
                    <td><c:out value = "${detailsProjet.descriptionProjet}" /></td> 
                    <td><c:out value = "${detailsProjet.nomMembre}" /></td> 
                    <td><c:out value = "${detailsProjet.idMembre}" /></td> 
                    <td><form method="post" action="SupprimerMembreServlet">


                            <input type="hidden" name="idMembre" value="<c:out value="${detailsProjet.idMembre}" />"/>
                            <input type="hidden" name="idCreateurProjet" value="<c:out value="${id}" />"/>
                            <button type="submit" name="submit"> Submit </button></form></td>
                </tr>
            </c:forEach>
        </table>
        <a href="pageAdministration.jsp"> Retour a la page d'administration </a>
    </body>
</body>
</html>
