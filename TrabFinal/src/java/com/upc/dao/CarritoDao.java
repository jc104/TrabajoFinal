/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Carrito;
import java.util.List;

/**
 *
 * @author LUIS-HP
 */
public interface CarritoDao {
    
    public void insertar (Carrito carrito);
    
    public void eliminar(int ccarrito);

    public void actualizar(Carrito carrito);

    public List<Carrito> Listar();

    public Carrito ListarId(int ccarrito);
    
    public List<Carrito> BuscarCarrito(String ncarrito);
    
    
    
    
    
}
