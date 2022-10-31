/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.AlbumDTO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author dell
 */
public interface AlbumDAO {
    public List<AlbumDTO> Select() throws SQLException;
    public int Insert(AlbumDTO album) throws SQLException;
    public int update(AlbumDTO album) throws SQLException;
    public int Delete(AlbumDTO album) throws SQLException;
    
}
