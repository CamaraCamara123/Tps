/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.dao;

import java.util.List;

/**
 *
 * @author Lachgar
 */
public interface IDao <T>{
    
    boolean create(T o );
    boolean update(T o );
    boolean delete(T o );
    List<T> getAll();
    T getById(int id);
    
}
