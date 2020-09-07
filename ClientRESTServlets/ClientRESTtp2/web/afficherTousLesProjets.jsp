<%-- 
    Document   : test
    Created on : 2020-08-09, 15:07:48
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
        <h1>Hello World!</h1>
        <h2>Liste de tous les projets : </h2>

        <p style="color:red">${EtatInvitation}</p>
        <table border="2">
            <tr>
                <th> Id projet :</th>
                <th> Nom du projet :</th>
                <th> Description :</th>
                <th> Id du Createur du projet :</th>
                <th> Membre a inviter : </th>
                
            </tr>
            <c:forEach var="projet" items="${Liste}">
                <tr>   
                    <td><c:out value = "${projet.idProjet}" /></td> 
                    <td><c:out value = "${projet.nom}" /></td> 
                    <td><c:out value = "${projet.description}" /></td> 
                    <td><c:out value = "${projet.idPersonne}" /></td> 
                    <td><form method="post" action="EnvoyerInvitationServlet">

                            <select name="membres" >
                                <c:forEach var="personne" items="${Personnes}">    
                                    <option value="${personne.idPersonne}">${personne.nom}</option>

                                </c:forEach>
                            </select>
                            <input type="text" name="invitationDescription" />
                            <input type="hidden" name="idPersonne" value="<c:out value="${projet.idPersonne}" />"/>
                                <input type="hidden" name="idProjet" value="<c:out value="${projet.idProjet}" />"/>
                            <button type="submit" name="submit"> Submit </button>


                        </form> </td>
                        
                      

                </tr>
            </c:forEach>

        </table>
        <a href="pageAdministration.jsp"> Retour a la page d'administration </a>
    </body>
</html>
