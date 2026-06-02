/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IUsuario;
import Model.Persona;
import Model.Rol;
import Model.Usuario;
import Util.ConexionSingleton;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JHOSMER
 */
public class UsuarioDaoImpl implements IUsuario {

    private Connection cn;

    @Override
    public Usuario validate(String user, String passw) {
          Usuario u = null;
        Persona p = null;
 
        PreparedStatement st;
        ResultSet rs;
        String query = null;
 
        try {
            u = new Usuario();
            p = new Persona();
            String hashedPassword = u.HasPassword(passw);
 
            query = " SELECT u.id_usuario, u.usuario, u.rol, p.id_persona,"
                    + " p.nombre"
                    + " FROM persona p, usuario u"
                    + " WHERE p.id_persona = u.id_persona"
                    + " AND u.usuario = ?"
                    + " AND u.contraseña = ?";
 
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setString(1, user);
            st.setString(2, hashedPassword);
            rs = st.executeQuery();
 
            if (rs.next()) {
                u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setRol(Rol.valueOf(rs.getString("rol").toUpperCase()));
                p.setId_persona(rs.getInt("id_persona"));
                p.setNombre(rs.getString("nombre"));
                u.setPersona(p);
            } else {
                u = null; // Si no encuentra el usuario, retornar null
            }
 
        } catch (Exception e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
            try {
                if (cn != null) cn.rollback();
            } catch (Exception ex) {
                System.out.println("Error del rollback: " + ex.getMessage());
            }
            u = null;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar conexión: " + e.getMessage());
                }
            }
        }
        return u;

    }

}
