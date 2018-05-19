/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Gerardo
 */
public class conectorBD {
    public Connection getConnection(){
        Connection cn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root","");
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage()); 
        }
        
        return cn;
        
    }
    
}
