/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;
import com.upc.entidades.Categoria;
import java.util.List;

/**
 *
 * @author LUIS-HP
 */
public interface CategoriaDao {
    
   public void insertar(Categoria categoria);

    public void eliminar(int ccategoria);

    public void actualizar(Categoria categoria);

    public List<Categoria> Listar();

    public Categoria ListarId(int ccategoria);
    
    public List<Categoria> BuscarCategoria(String ncategoria);
    
}
