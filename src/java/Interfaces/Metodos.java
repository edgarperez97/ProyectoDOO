package Interfaces;

import java.util.List;

/**
 *
 * @author edgar
 */
public interface Metodos <CualquierClase>{
    
    public boolean crear(CualquierClase c);
    public boolean borrar(Object key);
    public boolean actualizar(CualquierClase c);
    public CualquierClase leer(Object key);
    public List<CualquierClase> leerTodo();
    
}
