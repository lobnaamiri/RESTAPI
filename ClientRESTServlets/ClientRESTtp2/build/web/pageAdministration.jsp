<%-- 
    Document   : pageAdministration
    Created on : 2020-08-09, 14:18:18
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bonjour ${Personne.nom}</h1>
        
        <h2> Creer un projet </h2>
                <form method="post" action="CreerProjetServlet">
            <table border="2">
                <tr>
                    <td>
                         Nom du projet :
                    </td>
                     <td>
                         <input type="text" name="nomProjet">
                    </td>
                </tr>
                <tr>
                    <td> 
                        Description : 
                     </td>
                    <td>
                       <input type="text" name="descriptionProjet"> 
                    </td>
                </tr>
                    <tr>
                    <td> 
                       Votre id : 
                     </td>
                    <td>
                        <input type="text" name="idCreateurProjet" value="${id}" > 
                    </td>
                </tr>
                     <tr>
                   
                <tr>
                    <td colspan="2">
                <button type="submit" name="submit"> Submit </button>
                    </td>
                 </tr>
            </table>
        </form>
              <h2>Afficher tous les projets </h2>      
    <form method="post" action="AfficherProjetsServlet">
            <table border="2">
                <tr>
                    <td>
                         Afficher tous les projets  et envoyer des invitations:
                    </td>
                     <td>
                        <button type="submit" name="submit"> Submit </button>
                    </td>
                </tr>
               </table>
        </form>
        
              
              <h2>Afficher Les details de mes projets </h2>
                <form method="post" action="AfficherDetailsProjetsServlet">
            <table border="2">
                <tr>
                    <td>
                         Afficher mes projets :
                    </td>
                    <td>
                     <input type="text"  name="idPersonne" value="${id}">
                     <td>
                        <button type="submit" name="submit"> Submit </button>
                    </td>
                    
                </tr>
               </table>
        </form>
                     
                         <h2>Afficher toutes les invitations </h2>
                <form method="post" action="AfficherInvitationsServlet">
            <table border="2">
                <tr>
                    <td>
                         Afficher invitations : 
                    </td>
                    <td>
                     <input type="text"  name="idPersonne" value="${id}">
                     <td>
                        <button type="submit" name="submit"> Submit </button>
                    </td>
                    
                </tr>
               </table>
        </form>
    </body>
</html>
