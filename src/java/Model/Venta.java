/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;


public class Venta {
 private int idVenta;
 private Persona persona;
 private Usuario usuario;
 private Date fecha;
 private String estado;
 private Date fechaEntre;
 private String nDoc;

    public Venta() {
    }

    public Venta(int idVenta, Persona persona, Usuario usuario, Date fecha, String estado, Date fechaEntre, String nDoc) {
        this.idVenta = idVenta;
        this.persona = persona;
        this.usuario = usuario;
        this.fecha = fecha;
        this.estado = estado;
        this.fechaEntre = fechaEntre;
        this.nDoc = nDoc;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEntre() {
        return fechaEntre;
    }

    public void setFechaEntre(Date fechaEntre) {
        this.fechaEntre = fechaEntre;
    }

    public String getnDoc() {
        return nDoc;
    }

    public void setnDoc(String nDoc) {
        this.nDoc = nDoc;
    }
 
}
