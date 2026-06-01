/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author JHOSMER
 */
public class Det_Venta {
    private int det_venta;
    private Venta venta;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private String metodoPago;

    public Det_Venta() {
    }

    public Det_Venta(int det_venta, Venta venta, Producto producto, int cantidad, double precioUnitario, String metodoPago) {
        this.det_venta = det_venta;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.metodoPago = metodoPago;
    }

    public int getDet_venta() {
        return det_venta;
    }

    public void setDet_venta(int det_venta) {
        this.det_venta = det_venta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
}
