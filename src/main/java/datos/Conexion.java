/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dell
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:sqlite:C:\\Users\\dell\\OneDrive\\Documentos\\sqlite\\Chinook";
    
    public static Connection getConnection() throws Exception {
    
        return DriverManager.getConnection(JDBC_URL);
    
       
    }
}
