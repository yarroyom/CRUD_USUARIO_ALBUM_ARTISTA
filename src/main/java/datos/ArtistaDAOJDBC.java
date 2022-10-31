/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;


import dominio.ArtistaDTO;
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
public class ArtistaDAOJDBC implements ArtistaDAO{
    
      private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT Id_Artista, Nombre_s, Idioma FROM Artista";
    private static final String SQL_INSERT = "INSERT INTO Artista(Nombre_s, Idioma) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Artista SET Nombre_s=?, Idioma=? WHERE Id_Artista=?";
    private static final String SQL_DELETE = "DELETE FROM Artista WHERE Id_Artista=?";

    public ArtistaDAOJDBC() {

    }

    public ArtistaDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    

    @Override
    public List<ArtistaDTO> Select() throws SQLException {
      
           Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArtistaDTO Artis = null;
        List<ArtistaDTO> Art = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_Artista= rs.getInt("Id_Artista");
                String Nombre = rs.getString("Nombre_s");
                String Idioma = rs.getString("Idioma");
         
                
                Artis = new ArtistaDTO();
                Artis.setId_Artista(Id_Artista);
                Artis.setNombre_s(Nombre);
                Artis.setIdioma(Idioma);
            
                Art.add(Artis);
          
                
            }
        } catch(SQLException ex) {
            System.out.println("Hay un error en Select "+ex);
        } catch (Exception ex) {
            Logger.getLogger(AlbumDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Art; 
    
    }

    @Override
    public int Insert(ArtistaDTO serie) throws SQLException {
   Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, serie.getNombre_s());
            stmt.setString(2, serie.getIdioma());
          

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
        }catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
        } catch (Exception ex) {
              Logger.getLogger(ArtistaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
          }
        return rows;  
    
        
    }

    @Override
    public int update(ArtistaDTO serie) throws SQLException {
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
              System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, serie.getNombre_s());
            stmt.setString(2, serie.getIdioma());
             stmt.setInt(3, serie.getId_Artista());
     
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
            
        } catch(SQLException ex){
            System.out.println("Hay un erro en Update "+ex);
        } catch (Exception ex) {
              Logger.getLogger(ArtistaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
          }
        return rows;  
    
    }
    

    @Override
    public int Delete(ArtistaDTO serie) throws SQLException {
             Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, serie.getId_Artista());
            
            System.out.println("Ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un erro en Delete "+ex);
        } catch (Exception ex) {
              Logger.getLogger(ArtistaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
          }
        return rows;
    
    }
    
}
