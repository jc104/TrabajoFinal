/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Venta;
import java.util.List;

/**
 *
 * @author LUIS-HP
 */
public interface VentaDao {
    
   public void insertar(Venta venta);

    public void eliminar(int cventa);

    public void actualizar(Venta venta);

    public List<Venta> Listar();

    public Venta ListarId(int cventa);
   

    
}
