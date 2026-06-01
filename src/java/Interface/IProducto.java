/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Producto;
import java.util.List;

/**
 *
 * @author JHOSMER
 */
public interface IProducto {
    public List<Producto> listar();
    public boolean insertar(Producto p);
    public boolean actualizar(Producto p);
    public Producto buacarPorId(int id);
    public boolean eliminar(int id);
    public boolean actualizarStock(int id, int stock);
    public List<Producto> listarPorCategoria(int idCat);
}
