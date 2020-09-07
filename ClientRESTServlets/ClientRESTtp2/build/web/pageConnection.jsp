<%-- 
    Document   : pageConnection
    Created on : 2020-08-09, 13:44:36
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
        <form method="post" action="ConnectionServlet">
            <table border="2">
                <tr>
                    <td>
                         Courriel :
                    </td>
                     <td>
                         <input type="text" name="courriel">
                    </td>
                </tr>
                <tr>
                    <td> 
                         Mot de Passe : 
                     </td>
                    <td>
                       <input type="password" name="mdp"> 
                    </td>
                </tr>
             
                <tr>
                    <td colspan="2">
                <button type="submit" name="submit"> Submit </button>
                    </td>
                 </tr>
            </table>
        </form>
    </body>
</html>
