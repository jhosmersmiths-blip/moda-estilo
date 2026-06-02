/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IVenta;
import Model.Persona;
import Model.Usuario;
import Model.Venta;
import Util.ConexionSingleton;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author JHOSMER
 */
public class VentaDaoImpl implements IVenta {

    private Connection cn;

    @Override
    public List<Venta> listar() {
        List<Venta> lista = new ArrayList<>();

        try {
            String query = "SELECT * FROM venta";

            cn = ConexionSingleton.getConnection();
            PreparedStatement st = cn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Venta v = new Venta();
                Persona p = new Persona();
                Usuario u = new Usuario();

                v.setIdVenta(rs.getInt("id_venta"));
                v.setPersona(p);
                p.setId_persona(rs.getInt("id_persona"));
                v.setUsuario(u);
                u.setId_usuario(rs.getInt("id_usuario"));
                v.setFecha(rs.getDate("fecha"));
                v.setEstado(rs.getString("estado"));
                v.setFechaEntre(rs.getDate("fecha_entre"));
                v.setnDoc(rs.getString("Ndoc"));

                lista.add(v);
            }

        } catch (Exception e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public boolean insertar(Venta v) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "INSERT INTO venta(id_persona,id_usuario, fecha, estado, fecha_entre, Ndoc) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, v.getPersona().getId_persona());
            st.setInt(2, v.getUsuario().getId_usuario());
            st.setDate(3, v.getFecha());
            st.setString(4, v.getEstado());
            st.setDate(5, v.getFechaEntre());
            st.setString(6, v.getnDoc());
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar venta: " + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                System.out.println("Error del rollback: " + ex.getMessage());
            }
        } finally {
            if (cn != null) {
                try {
                } catch (Exception ex) {
                }
            }
        }
        return r > 0;
    }

    @Override
    public boolean actualizar(Venta v) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "UPDATE venta SET id_persona=?,id_usuario=?, fecha=?, estado=?, fecha_entre=?, Ndoc=? "
                    + "WHERE id_venta=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, v.getPersona().getId_persona());
            st.setInt(2, v.getUsuario().getId_usuario());
            st.setDate(3, v.getFecha());
            st.setString(4, v.getEstado());
            st.setDate(5, v.getFechaEntre());
            st.setString(6, v.getnDoc());
            st.setInt(7, v.getIdVenta());
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar venta: " + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                System.out.println("Error del rollback: " + ex.getMessage());
            }
        } finally {
            if (cn != null) {
                try {
                } catch (Exception ex) {
                }
            }
        }
        return r > 0;
    }

    @Override
    public Venta buscarPorId(int id) {
        Venta v = null;
        Persona p = null;
        Usuario u = null;
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        try {
            query = "SELECT * FROM venta WHERE id_venta=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                ;
                v.setIdVenta(rs.getInt("id_venta"));
                v.setPersona(p);
                p.setId_persona(rs.getInt("id_persona"));
                v.setUsuario(u);
                u.setId_usuario(rs.getInt("id_usuario"));
                v.setFecha(rs.getDate("fecha"));
                v.setEstado(rs.getString("estado"));
                v.setFechaEntre(rs.getDate("fecha_entre"));
                v.setnDoc(rs.getString("Ndoc"));

            }
        } catch (Exception e) {
            System.out.println("Error al buscar venta: " + e.getMessage());
        } finally {
            if (cn != null) {
                try {
                } catch (Exception ex) {
                }
            }
        }
        return v;
    }

    @Override
    public boolean eliminar(int id) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "DELETE FROM venta WHERE id_venta=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar venta: " + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
                System.out.println("Error del rollback: " + ex.getMessage());
            }
        } finally {
            if (cn != null) {
                try {
                } catch (Exception ex) {
                }
            }
        }
        return r > 0;
    }

    @Override
    public List<Venta> listarPorCliente(int id_persona) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
