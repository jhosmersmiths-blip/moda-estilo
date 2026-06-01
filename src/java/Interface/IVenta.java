/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Venta;
import java.util.List;

/**
 *
 * @author JHOSMER
 */
public interface IVenta {
    public List<Venta> listar();
    public boolean insertar(Venta v);
    public boolean actualizar(Venta v);
    public Venta buscarPorId(int id);
    public boolean eliminar(int id);
    public List<Venta> listarPorCliente(int id_persona);
}
