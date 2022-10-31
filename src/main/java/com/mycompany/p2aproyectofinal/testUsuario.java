/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2aproyectofinal;

import datos.Conexion;
import datos.UsuarioDAOJDBC;
import dominio.UsuarioDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dell
 */
public class testUsuario {
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
            
            UsuarioDAOJDBC usuarioJdbc = new UsuarioDAOJDBC();
            List<UsuarioDTO> us = usuarioJdbc.Select();
            
            System.out.println("Usuarios" + us.toString());
           
            
            UsuarioDTO cambioUsuario = new UsuarioDTO();
            cambioUsuario.setId_Usuario(4);
            cambioUsuario.setUsername("arroyo");
            cambioUsuario.setPassword("123");
             usuarioJdbc.Delete(cambioUsuario);


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
