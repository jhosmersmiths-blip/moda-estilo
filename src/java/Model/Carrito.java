/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author JHOSMER
 */
public class Carrito {
private int idCarrito;
private Det_Venta detventa;

    public Carrito() {
    }

    public Carrito(int idCarrito, Det_Venta detventa) {
        this.idCarrito = idCarrito;
        this.detventa = detventa;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Det_Venta getDetventa() {
        return detventa;
    }

    public void setDetventa(Det_Venta detventa) {
        this.detventa = detventa;
    }

}
