/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author JHOSMER
 */
public class Categoria {
    private int idCat;
    private String tipoCat;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int idCat, String tipoCat, String descripcion) {
        this.idCat = idCat;
        this.tipoCat = tipoCat;
        this.descripcion = descripcion;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getTipoCat() {
        return tipoCat;
    }

    public void setTipoCat(String tipoCat) {
        this.tipoCat = tipoCat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
