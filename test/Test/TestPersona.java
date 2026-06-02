/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dao.PersonaDaoImpl;
import Dao.UsuarioDaoImpl;
import Interface.IPersona;
import Interface.IUsuario;
import Model.Persona;
import Model.Rol;
import Model.Usuario;

/**
 *
 * @author JHOSMER
 */
public class TestPersona {

    IPersona pdao = new PersonaDaoImpl();
    IUsuario udao = new UsuarioDaoImpl();

    public static void main(String[] args) {
        TestPersona t = new TestPersona();
        t.insert();
        //t.valid_user();
    }

    public void insert() {
        Persona p = new Persona();

        p.setNombre("juan");
        p.setEmail("juan@gmail.com");
        p.setTelefono("985672745");
        p.setDireccion("av. tu sabras");

        Usuario u = new Usuario();

        u.setContraseña("juan123");
        u.setRol(Rol.CLIENTE);
        int result = pdao.insertar(p, u);
        if (result > 0) {
            System.out.println("Persona y Usuario creada");
            System.out.println("Usuario:" + p.getEmail());
            System.out.println("Rol asignado:" + u.getRol());
        } else {
            System.out.println("No se pudo realizar el registro");
        }
    }

    public void valid_user() {
        Usuario u = udao.validate("jhosmersmiths@gmail.com", "admin123");
        if (u != null && u.getPersona() != null) {
            System.out.println("Bienvenido" + u.getPersona().getNombre());
            System.out.println("Rol:" + u.getRol());
            System.out.println("Usuario:" + u.getUsuario());
            System.out.println("User_id:" + u.getId_usuario());
            System.out.println("persona_id:" + u.getPersona().getId_persona());
        } else {
            System.out.println("Credenciales incorrectas");

        }
    }
}
