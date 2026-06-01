/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Det_Venta;
import java.util.List;

/**
 *
 * @author JHOSMER
 */
public interface IDetalleVenta {
    public List<Det_Venta> listar();
    public boolean insertar(Det_Venta dv);
    public boolean actualizar(Det_Venta dv);
    public Det_Venta buscarPorId(int id);
    public boolean eliminar(int id);
}
