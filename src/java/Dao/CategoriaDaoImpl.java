/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.ICategoria;
import Model.Categoria;
import Util.ConexionSingleton;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author JHOSMER
 */
public class CategoriaDaoImpl implements ICategoria {

    private Connection cn;

    @Override
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        try {
            query = "SELECT * FROM categoria";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdCat(rs.getInt("id_cat"));
                c.setTipoCat(rs.getString("tipo_cat"));
                c.setDescripcion(rs.getString("descripcion"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al listar categorías: " + e.getMessage());
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
    public boolean insertar(Categoria c) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "INSERT INTO categoria(tipo_cat, descripcion) "
                    + "VALUES(?,?)";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setString(1, c.getTipoCat());
            st.setString(2, c.getDescripcion());
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar categoría: " + e.getMessage());
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
    public boolean actualizar(Categoria c) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "UPDATE categoria SET tipo_cat=?, descripcion=? WHERE id_cat=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setString(1, c.getTipoCat());
            st.setString(2, c.getDescripcion());
            st.setInt(3, c.getIdCat());
            
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar categoría: " + e.getMessage());
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
    public Categoria buscarPorId(int id) {
        Categoria c = null;
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        try {
            query = "SELECT * FROM categoria WHERE id_cat=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                c = new Categoria();
                c.setIdCat(rs.getInt("id_cat"));
                c.setTipoCat(rs.getString("tipo_cat"));
                c.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar categoría: " + e.getMessage());
        } finally {
            if (cn != null) {
                try {
                } catch (Exception ex) {
                }
            }
        }
        return c;
    }

    @Override
    public boolean eliminar(int id) {
        int r = 0;
        PreparedStatement st;
        String query = null;
        try {
            query = "DELETE FROM categoria WHERE id_cat=?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            r = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar categoría: " + e.getMessage());
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
