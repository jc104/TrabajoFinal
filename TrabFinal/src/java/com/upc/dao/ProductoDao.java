/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Producto;
import java.util.List;

/**
 *
 * @author LUIS-HP
 */
public interface ProductoDao {
    
    public void insertar(Producto producto);

    public void eliminar(int cproducto);

    public void actualizar(Producto producto);

    public List<Producto> Listar();

    public Producto ListarId(int cproducto);
    
    public List<Producto> BuscarCategoria(String nproducto);
    
}
