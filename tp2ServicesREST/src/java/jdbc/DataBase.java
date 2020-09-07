/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DataBase {
    
     private static Connection cnx;
    private static String url = "jdbc:mysql://localhost/tp2?serverTimezone=UTC";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "root";

    public static Connection getConnection(){
        
        
          try {
            if (cnx==null || cnx.isClosed()) {
                Class.forName(driver);
                cnx = DriverManager.getConnection(url, user, password);
               
            }
        } catch (SQLException ex) {
            System.out.println("ERREUR : "+ex);
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERREUR : "+ex);
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    
    }
    
     public static void close() {
        try {
            if (cnx!=null) {
                cnx.close();
                cnx = null;
            }
        } catch (SQLException ex) {
            System.out.println("ERREUR : "+ex);
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
