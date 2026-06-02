/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IDetalleVenta;
import Model.Det_Venta;
import Model.Producto;
import Model.Venta;
import Util.ConexionSingleton;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author JHOSMER
 */
public class DetalleVentaDaoImpl implements IDetalleVenta {

    private Connection cn;

    @Override
    public List<Det_Venta> listar() {
        List<Det_Venta> lista = new ArrayList<>();
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        try {
            query = "SELECT * FROM detalle_venta";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                Det_Venta dv = new Det_Venta();

                Venta v = new Venta();
                v.setIdVenta(rs.getInt("id_venta"));
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                dv.setVenta(v);
                dv.setProducto(p);
                dv.setCantidad(rs.getInt("cantidad"));
                dv.setPrecioUnitario(rs.getDouble("precioUnitario"));
                dv.setMetodoPago(rs.getString("metodoPago"));

            }
        } catch (Exception e) {
            System.out.println("Error al listar detalles de venta: " + e.getMessage());
        } finally {
            if (cn != null) {
                try {
                } catch (Exception ex) {
                }
            }
        }
        return lista;
    }

    @Override
    public boolean insertar(Det_Venta dv) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "INSERT INTO detalle_venta(id_venta, id_producto, cantidad, precioUnitario, metodoPago) "
                    + "VALUES(?, ?, ?, ?, ?)";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, dv.getVenta().getIdVenta());
            st.setInt(2, dv.getProducto().getIdProducto());
            st.setInt(3, dv.getCantidad());
            st.setDouble(4, dv.getPrecioUnitario());
            st.setDouble(5, dv.getCantidad());
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar detalle de venta: " + e.getMessage());
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
    public boolean actualizar(Det_Venta dv) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "UPDATE detalle_venta SET id_venta=?, id_producto=?, cantidad=?, "
                    + "precioIUnitario=?, metodoPago=? WHERE id_detalleVenta=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, dv.getVenta().getIdVenta());
            st.setInt(2, dv.getProducto().getIdProducto());
            st.setInt(3, dv.getCantidad());
            st.setDouble(4, dv.getPrecioUnitario());
            st.setDouble(5, dv.getCantidad());
            st.setInt(6, dv.getDet_venta());
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar detalle de venta: " + e.getMessage());
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
    public Det_Venta buscarPorId(int id) {
        Det_Venta dv = null;
        Venta v = null;
        Producto p = null;
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        try {
            query = "SELECT * FROM detalle_venta WHERE id_detalleVenta=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                
                dv.setDet_venta(rs.getInt("id_detalleVenta"));
                dv.setVenta(v);
                v.setIdVenta(rs.getInt("id_venta"));
                dv.setProducto(p);
                p.setIdProducto(rs.getInt("id_producto"));
                dv.setCantidad(rs.getInt("cantidad"));
                dv.setPrecioUnitario(rs.getDouble("precioUnitario"));
                dv.setMetodoPago(rs.getString("metodoPago"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar detalle de venta: " + e.getMessage());
        } finally {
            if (cn != null) {
                try {
                } catch (Exception ex) {
                }
            }
        }
        return dv;
    }

    @Override
    public boolean eliminar(int id) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "DELETE FROM detalle_venta WHERE id_detalle=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar detalle de venta: " + e.getMessage());
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

}
