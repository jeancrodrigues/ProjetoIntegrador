/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

public interface IPersistencia<T> {    
    public T gravar(T t) ;
    public void deletar(int id) ;
    public void deletar(T t);
    public T atualizar(T t);
    public T procurarPorId(int id);
    public List<T> getLista();    
}
