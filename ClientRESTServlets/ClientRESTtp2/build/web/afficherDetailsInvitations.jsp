<%-- 
    Document   : afficherDetailsInvitations
    Created on : 2020-08-09, 18:16:35
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
                <th> Id Invitation :</th>
                <th> Votre Id :</th>
                <th> Id du projet :</th>
                <th> Description du projet :</th>
                <th> Nom du projet :</th>
                <th> Votre Statut dans l'equipe</th>
                <th> Repondre </th>
                
            </tr>
            <c:forEach var="invitation" items="${DetailsInvitations}">
                <tr>   
                    <td> <input type="text" name="idInvitation" value="<c:out value="${invitation.idInvitation}" />" readonly/></td>
                    <td> <input type="text" name="idPersonne" value="<c:out value="${invitation.idPersonne}"/>" readonly/></td>
                    <td> <input type="text" name="idProjet" value="<c:out value="${invitation.idProjet}"/>" readonly/></td>
                    <td> <input type="text" name="description" value="<c:out value="${invitation.description}"/>"readonly/></td>
                    <td> <input type="text" name="nomProjet" value="<c:out value="${invitation.nomProjet}"/>" readonly/></td>
                    <td><input type="text" name="nomProjet" value="<c:out value="${invitation.reponse}"/>" readonly/></td>
                    <td><form method="post" action="EnregistrerReponseInvitationServlet">

                            <select name="reponse">
                                <option value="true">Accepter</option>
                                <option value="false">Refuser</option>

                            </select>
                                <input type="hidden" name="idPersonne" value="<c:out value="${invitation.idPersonne}" />"/>
                                <input type="hidden" name="idProjet" value="<c:out value="${invitation.idProjet}" />"/>
                            <button type="submit" name="submit"> Submit </button></form></td>
                
                </tr>
                        </c:forEach>
        </table>
        <a href="pageAdministration.jsp"> Retour a la page d'administration </a>
    </body>
</html>
