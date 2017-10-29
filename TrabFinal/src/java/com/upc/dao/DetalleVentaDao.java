/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.DetalleVenta;
import java.util.List;

/**
 *
 * @author LUIS-HP
 */
public interface DetalleVentaDao {
    
    public void insertar(DetalleVenta detalleventa);

    public void eliminar(int cdetalleventa);

    public void actualizar(DetalleVenta detalleventa);

    public List<DetalleVenta> Listar();

    public DetalleVenta ListarId(int cdetalleventa);
    



    
}
