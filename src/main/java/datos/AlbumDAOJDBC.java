/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.AlbumDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class AlbumDAOJDBC implements AlbumDAO{
    
       
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT Id_Album, Cancion_p, F_Genero_Musical FROM Album";
    private static final String SQL_INSERT = "INSERT INTO Album(Cancion_p, F_Genero_Musical) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Album SET Cancion_p=?, F_Genero_Musical=? WHERE Id_Album=?";
    private static final String SQL_DELETE = "DELETE FROM Album WHERE Id_Album=?";

     public AlbumDAOJDBC() {

    }

    public AlbumDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    

    @Override
    public List<AlbumDTO> Select() throws SQLException {
        
           Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AlbumDTO Albu = null;
        List<AlbumDTO> Album = new ArrayList<AlbumDTO>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("Id_Album");
                String Cancion = rs.getString("Cancion_p");
                String fGenero = rs.getString("f_Genero_Musical");
         
                
                Albu = new AlbumDTO();
                Albu.setId_Album(id_usuario);
                Albu.setCancion_p(Cancion);
                Albu.setF_Genero_Musical(fGenero);
            
                Album.add(Albu);
          
                
            }
        } catch(SQLException ex) {
            System.out.println("Hay un error en Select "+ex);
        } catch (Exception ex) {
            Logger.getLogger(AlbumDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Album; 
    }

    @Override
    public int Insert(AlbumDTO album) throws SQLException {
      Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, album.getCancion_p());
            stmt.setString(2, album.getF_Genero_Musical());
          

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
        }catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
      
        } catch (Exception ex) {
            Logger.getLogger(AlbumDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    
    }

    @Override
    public int update(AlbumDTO album) throws SQLException {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
             System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, album.getCancion_p());
            stmt.setString(2, album.getF_Genero_Musical());
             stmt.setInt(3, album.getId_Album());
            
           
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
            
        } catch(SQLException ex){
            System.out.println("Hay un erro en Update "+ex);
        } catch (Exception ex) {
            Logger.getLogger(AlbumDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;  
    
    }

    @Override
    public int Delete(AlbumDTO album) throws SQLException {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, album.getId_Album());
            
            System.out.println("Ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un erro en Delete "+ex);
        } catch (Exception ex) {
            Logger.getLogger(AlbumDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    }
        
        
        
        
      
    

    
    

