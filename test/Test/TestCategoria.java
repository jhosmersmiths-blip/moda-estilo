/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dao.CategoriaDaoImpl;
import Interface.ICategoria;
import Model.Categoria;
import java.util.List;

/**
 *
 * @author JHOSMER
 */
public class TestCategoria {

    public static ICategoria dao = new CategoriaDaoImpl();
    public static void main(String[] args) {
        TestCategoria t = new TestCategoria();
        //t.agregar();
        t.listar();
    }
    public static void listar() {
        List<Categoria> lista = dao.listar();
        if (lista != null && !lista.isEmpty()) {
            System.out.println("ID\tTipo\tDescripcion");
            for (Categoria c : lista) {
                System.out.println(c.getIdCat()
                        + "\t" + c.getTipoCat()
                        + "\t" + c.getDescripcion());
            }
        } else {
            System.out.println("No hay categorías registradas.");
        }
    }
 
    public static void agregar() {
        Categoria c = new Categoria();
        c.setTipoCat("mujer");
        c.setDescripcion("Prendas para mujer");
 
        boolean result = dao.insertar(c);
        if (result) {
            System.out.println("Categoría registrada correctamente.");
        } else {
            System.out.println("Error al registrar categoría.");
        }
    }
 
    public static void actualizar() {
        Categoria c = new Categoria();
        c.setIdCat(1);
        c.setTipoCat("Ropa Formal");
        c.setDescripcion("Prendas para ocasiones formales");
 
        boolean result = dao.actualizar(c);
        if (result) {
            System.out.println("Categoría actualizada correctamente.");
        } else {
            System.out.println("Error al actualizar categoría.");
        }
    }
 
    public static void buscarPorId() {
        Categoria c = dao.buscarPorId(1);
        if (c != null) {
            System.out.println("ID: " + c.getIdCat());
            System.out.println("Tipo: " + c.getTipoCat());
            System.out.println("Descripción: " + c.getDescripcion());
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }
 
    public static void eliminar() {
        boolean result = dao.eliminar(3);
        if (result) {
            System.out.println("Categoría eliminada correctamente.");
        } else {
            System.out.println("Error al eliminar categoría.");
        }
    }
}
