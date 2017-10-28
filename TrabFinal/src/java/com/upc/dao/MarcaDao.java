/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Marca;
import java.util.List;

/**
 *
 * @author LUIS-HP
 */
public interface MarcaDao {
    
    public void insertar(Marca marca);

    public void eliminar(int cmarca);

    public void actualizar(Marca marca);

    public List<Marca> Listar();

    public Marca ListarId(int cmarca);
    
    public List<Marca> BuscarMarca(String nmarca);
    
}
