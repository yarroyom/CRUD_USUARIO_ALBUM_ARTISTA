/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2aproyectofinal;

import datos.AlbumDAOJDBC;
import datos.Conexion;
import dominio.AlbumDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dell
 */
public class testAlbum {
     public static void main(String[] args) throws Exception {
        Connection conexion = null;
        
        System.out.println("Hola");
        
         try {
            
              conexion= Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("conexion exitosa");
            }else{
                System.out.println("Conexion fallida");
            }
            
            AlbumDAOJDBC album = new AlbumDAOJDBC();
            List<AlbumDTO> us = album.Select();
            
            System.out.println("Usuarios" + us.toString());
            
            AlbumDAOJDBC Albu= new AlbumDAOJDBC(conexion);
         
            
            AlbumDTO peliculadto = new AlbumDTO();
     AlbumDTO peliculadtonew = new AlbumDTO();
       conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
         } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
             try {
                  conexion.rollback();
             } catch (Exception ex1) {
                  ex1.printStackTrace(System.out);
             }
             
         }
     }}
        
        
        
