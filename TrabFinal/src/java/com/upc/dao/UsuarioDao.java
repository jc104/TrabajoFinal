/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Usuario;



public interface UsuarioDao {

    public Usuario login(String nombreusuario, String passwordusuario);
}
