/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IProducto;
import Model.Categoria;
import Model.Producto;
import Util.ConexionSingleton;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author JHOSMER
 */
public class ProductoDaoImpl implements IProducto {

    private Connection cn;

    @Override
    public List<Producto> listar() {
        List<Producto> lista = null;
        Producto pr;
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        try {
            query = " SELECT id_producto, id_cat, nombre, descripcion,"
                    + " talla, color, precio,stock FROM producto ";

            lista = new ArrayList<>();
            //if (cn == null || cn.isClosed()) {
            // System.out.println("La conexion es nula o esta cerrada");
            //}
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            rs = st.executeQuery();

            while (rs.next()) {
                pr = new Producto();
                pr.setIdProducto(rs.getInt("id_producto"));
                pr.setNombre(rs.getString("nombre"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setPrecio(rs.getDouble("precio"));
                pr.setStock(rs.getInt("stock"));
                lista.add(pr);
            }

        } catch (Exception e) {
            System.out.println("Error al listar:" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            System.out.println("no se pudo listar el producto");
        } finally {
            if (cn != null) {
                try {

                } catch (Exception e) {
                }
            }
        }
        return lista;
    }

    @Override
    public boolean insertar(Producto p) {
        boolean flag = false;
        PreparedStatement st;
        String query = null;

        try {
            query = "INSERT INTO producto(id_cat,nombre,descripcion, talla, color, precio, stock, imagen)"
                    + " VALUES(?,?,?,?,?,?,?,?)";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, p.getCategoria().getIdCat());
            st.setString(2, p.getNombre());
            st.setString(3, p.getDescripcion());
            st.setString(4, p.getTalla());
            st.setString(5, p.getColor());
            st.setDouble(6, p.getPrecio());
            st.setInt(7, p.getStock());
            st.setString(8, p.getImagen());

            st.executeUpdate();
            flag = true;

        } catch (Exception e) {
            System.out.println("Error al agregar un producto");
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            flag = false;
            System.out.println("Error: no se pudo agregar al registro");
        } finally {
            if (cn != null) {
                try {

                } catch (Exception e) {
                    System.out.println("Error al cerrar la conexion");
                }
            }
        }
        return flag;
    }

    @Override
    public boolean actualizar(Producto p) {
        boolean flag = false;
        PreparedStatement st;
        String query = null;
        try {

            query = "UPDATE producto SET id_cat = ?,nombre = ?, descripcion = ?, "
                    + "talla = ?, color = ?, precio = ?, stock = ?, imagen = ? "
                    + "WHERE id_producto = ?";

            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, p.getCategoria().getIdCat());
            st.setString(2, p.getNombre());
            st.setString(3, p.getDescripcion());
            st.setString(4, p.getTalla());
            st.setString(5, p.getColor());
            st.setDouble(6, p.getPrecio());
            st.setInt(7, p.getStock());
            st.setString(8, p.getImagen());
            st.setInt(9, p.getIdProducto());

            st.executeUpdate();

            flag = true;

        } catch (Exception e) {

            System.out.println("Error de actualizacion: " + e.getMessage());

            try {
                cn.rollback();
            } catch (Exception ex) {
            }

            flag = false;

        } finally {

            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar la conexion " + e.getMessage());
                }
            }
        }

        return flag;
    }

    @Override
    public Producto buacarPorId(int id) {
        Producto prod = null;
        Categoria cat = null;
        PreparedStatement st;
        //declarar variable que va conectar el SQL de insercion
        ResultSet rs;
        String query = null;

        try {
            query = "SELECT * FROM producto WHERE id_producto =?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                prod = new Producto();
                prod.setIdProducto(rs.getInt("id_producto"));
                cat.setIdCat(rs.getInt("id_cat"));
                prod.setCategoria(cat);
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setTalla(rs.getString("talla"));
                prod.setColor(rs.getString("color"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setImagen(rs.getString("imagen"));
            }
        } catch (Exception e) {
            System.out.println("error de busqueda" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {

            }
            System.out.println("no se pudo buscar el por id");

        } finally {
            if (cn != null) {
                try {

                } catch (Exception e) {
                    System.out.println("error al cerrar la conexion" + e.getMessage());
                }
            }
        }
        return prod;
    }

    @Override
    public boolean eliminar(int id) {
        boolean flag = false;
        PreparedStatement st;

        String query = null;
        try {
            query = "DELETE FROM producto WHERE id_producto = ?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);

            st.executeUpdate();
            flag = true;

        } catch (Exception e) {
            System.out.println("Error al eliminar" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {

            }
            flag = false;
            System.out.println("Error , no se elimino el registro");
        } finally {
            if (cn != null) {
                try {

                } catch (Exception e) {
                    System.out.println("Error al cerrar la conexion" + e.getMessage());
                }
            }
        }
        return flag;
    }

    @Override
    public boolean actualizarStock(int id, int stock) {
        boolean flag = false;
        PreparedStatement st;
        String query = null;

        try {
            query = "UPDATE producto SET stock = ? WHERE id_producto = ?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, stock);
            st.setInt(2, id);

            st.executeUpdate();
            flag = true;

        } catch (Exception e) {
            System.out.println("Error al actualizar stock: " + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            flag = false;
            System.out.println("Error: no se pudo actualizar el stock");
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar la conexion: " + e.getMessage());
                }
            }
        }
        return flag;
    }

    @Override
    public List<Producto> listarPorCategoria(int idCat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
