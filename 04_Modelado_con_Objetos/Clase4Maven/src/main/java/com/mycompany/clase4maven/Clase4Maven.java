/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase4maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gonza
 */
public class Clase4Maven {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello World!");
        
        Connection conectar = null;
        String sURL = "jdbc:mysql://localhost:3306/facturacion";

  
        Class.forName("com.mysql.cj.jdbc.Driver");
    
        try {
             conectar = (Connection) DriverManager.getConnection(sURL,"root","lamanzana");
        JOptionPane.showMessageDialog(null,"Conexion Exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
