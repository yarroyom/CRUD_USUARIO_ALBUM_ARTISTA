/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.ArtistaDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dell
 */
public interface ArtistaDAO {
     public List<ArtistaDTO> Select() throws SQLException;
    public int Insert(ArtistaDTO serie) throws SQLException;
    public int update(ArtistaDTO serie) throws SQLException;
    public int Delete(ArtistaDTO serie) throws SQLException;
}
