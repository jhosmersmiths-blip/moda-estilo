/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IPersona;
import Model.Persona;
import Model.Rol;
import Model.Usuario;
import Util.ConexionSingleton;
import java.util.List;
import java.sql.*;

/**
 *
 * @author JHOSMER
 */
public class PersonaDaoImpl implements IPersona {

    private Connection cn;

    @Override
    public List<Persona> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertar(Persona p, Usuario u) {
        PreparedStatement st;
        String query = null;
        ResultSet rs;
        int id_persona = 0;
        int r = 0;

        try {
            cn = ConexionSingleton.getConnection();
            cn.setAutoCommit(false); // Activar transacción manual

            query = "INSERT INTO persona(nombre,email,direccion,telefono) VALUES(?, ?, ?, ?)";
            st = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, p.getNombre());
            st.setString(2, p.getEmail());
            st.setString(3, p.getDireccion());
            st.setString(4, p.getTelefono());
            r = st.executeUpdate();

            if (r != 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    id_persona = rs.getInt(1);
                    System.out.println("id_persona:" + id_persona);
                }

                if (id_persona > 0) {
                    u.setRol(Rol.CLIENTE);
                    String hashpassword = u.HasPassword(u.getContraseña());
                    query = "INSERT INTO usuario (usuario,contraseña,rol,id_persona) VALUES(?, ?, ?, ?)";
                    st = cn.prepareStatement(query);
                    st.setString(1, p.getEmail());
                    st.setString(2, hashpassword);
                    st.setString(3, u.getRol().name());
                    st.setInt(4, id_persona);
                    r = st.executeUpdate();
                } else {
                    System.out.println("Error al agregar una persona");
                }
            }

            cn.commit(); // Confirmar transacción si todo salió bien

        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
            try {
                cn.rollback(); // Revertir cambios si hubo error
            } catch (Exception ex) {
                System.out.println("Error del rollback: " + ex.getMessage()); // corregido: ex en lugar de e
            }
        } finally {
            if (cn != null) {
                try {
                    cn.setAutoCommit(true); // Restaurar autocommit
                    cn.close();
                } catch (Exception ex) {
                    System.out.println("Error al cerrar conexión: " + ex.getMessage());
                }
            }
        }
        return r;
    }

    @Override
    public boolean actualizar(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona buscarPorEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
