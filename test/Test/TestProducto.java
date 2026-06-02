/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dao.ProductoDaoImpl;
import Interface.IProducto;
import Model.Categoria;
import Model.Producto;
import java.util.List;

/**
 *
 * @author JHOSMER
 */
public class TestProducto {

    public static IProducto dao = new ProductoDaoImpl();

    public static void main(String[] args) {
        TestProducto t = new TestProducto();
        //t.agregar();
        //t.listar();
        //t.buscarPorId();
        t.actualizar();
        //t.actualizarStock();
        //t.elimnar();

    }

    public static void listar() {

        List<Producto> lista = dao.listar();

        if (lista != null && !lista.isEmpty()) {
            System.out.println("ID\tNombre\tPrecio\tStock");
            for (Producto p : lista) {
                System.out.println(p.getIdProducto()
                        + "\t" + p.getNombre() + "\t$"
                        + p.getPrecio() + "\t" + p.getStock());
            }
        } else {
            System.out.println("No hay Productos");
        }
    }

    public static void agregar() {
        Producto p = new Producto();
        Categoria c = new Categoria();
        p.setNombre("pantalon");
        p.setDescripcion("pantalon de vestir ");
        c.setIdCat(1);
        p.setCategoria(c);
        p.setTalla("L");
        p.setColor("negro");
        p.setPrecio(70);
        p.setStock(10);
        p.setImagen("/resoouces/img/pantalon.jpg");

        boolean result = dao.insertar(p);
        if (result) {
            System.out.println("Producto Registrado ");
        } else {
            System.out.println("Error de registro");

        }
    }

    public static void actualizar() {
        Producto p = new Producto();
        Categoria c = new Categoria();
         p.setIdProducto(1);
        p.setNombre("camisa");
        p.setDescripcion("camisa de vestir ");
        c.setIdCat(1);
        p.setCategoria(c);
        p.setTalla("L");
        p.setColor("celeste");
        p.setPrecio(80);
        p.setStock(5);
        p.setImagen("/resoouces/img/camisa.jpg");
        boolean result = dao.actualizar(p);
        if (result) {
            System.out.println("Registro actualizado");
        } else {
            System.out.println("Error de actualizacion");

        }
    }

    public void buscarPorId() {
        Producto prod = dao.buacarPorId(3);
        if (prod != null) {
            System.out.println("ID:" + prod.getIdProducto());
            System.out.println("Nombre:" + prod.getNombre());
            System.out.println("descripcion:" + prod.getDescripcion());
            System.out.println("precio:" + prod.getPrecio());
            System.out.println("stock:" + prod.getStock());
            System.out.println("Ruta img:" + prod.getImagen());
        } else {
            System.out.println("producto no encontrado");
        }
    }

    public void elimnar() {
        Producto pr = new Producto();
        pr.setIdProducto(2);
        boolean result = dao.eliminar(2);
        if (result) {
            System.out.println("Registro eliminado");
        } else {
            System.out.println("Error de eliminacion");

        }
    }

    public static void actualizarStock() {
        boolean result = dao.actualizarStock(5, 100);
        if (result) {
            System.out.println("Stock actualizado correctamente");
        } else {
            System.out.println("Error al actualizar el stock");
        }
    }
}
