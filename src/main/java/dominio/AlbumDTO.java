/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;



/**
 *
 * @author dell
 */
public class AlbumDTO {
     private int Id_Album;
    private String Cancion_p;
    private String F_Genero_Musical;
   

    public AlbumDTO(int Id_Album, String Cancion_p, String F_Genero_Musical) {
        this.Id_Album = Id_Album;
        this.Cancion_p = Cancion_p;
        this.F_Genero_Musical = F_Genero_Musical;
       
    }

    public AlbumDTO() {
        
    }

    /**
     * @return the Id_Album
     */
    public int getId_Album() {
        return Id_Album;
    }

    /**
     * @param Id_Album the Id_Album to set
     */
    public void setId_Album(int Id_Album) {
        this.Id_Album = Id_Album;
    }

    /**
     * @return the Cancion_p
     */
    public String getCancion_p() {
        return Cancion_p;
    }

    /**
     * @param Cancion_p the Cancion_p to set
     */
    public void setCancion_p(String Cancion_p) {
        this.Cancion_p = Cancion_p;
    }

    /**
     * @return the F_Genero_Musical
     */
    public String getF_Genero_Musical() {
        return F_Genero_Musical;
    }

    /**
     * @param F_Genero_Musical the F_Genero_Musical to set
     */
    public void setF_Genero_Musical(String F_Genero_Musical) {
        this.F_Genero_Musical = F_Genero_Musical;
    }
    @Override
    public String toString() {
        return "AlbumDTO{" + "Id_Album=" + Id_Album + ", Cancion_p=" + Cancion_p + ", F_Genero_Musical=" + F_Genero_Musical  + '}';
    }

}
