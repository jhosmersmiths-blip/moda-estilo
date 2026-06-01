/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Categoria;
import java.util.List;

/**
 *
 * @author JHOSMER
 */
public interface ICategoria {
    public List<Categoria> listar();
    public boolean insertar(Categoria c);
    public boolean actualizar(Categoria c);
    public Categoria buscarPorId(int id);
    public boolean eliminar(int id);
 
}
