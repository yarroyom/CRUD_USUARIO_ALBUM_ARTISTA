/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2aproyectofinal;

import datos.ArtistaDAOJDBC;
import datos.Conexion;
import dominio.ArtistaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;




/**
 *
 * @author dell
 */
public class testArtista {
   public static void main(String[] args) throws Exception {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("coneccion exitosa");
            }else{
                System.out.println("Conexion fallida");
            }
            
            ArtistaDAOJDBC Artista = new ArtistaDAOJDBC();
            List<ArtistaDTO> us = Artista.Select();
            System.out.println("Usuarios" + us.toString());
            
            ArtistaDAOJDBC serie = new ArtistaDAOJDBC(conexion);
            ArtistaDTO seriesdto = new ArtistaDTO();

           
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
                    
     
    }
    

