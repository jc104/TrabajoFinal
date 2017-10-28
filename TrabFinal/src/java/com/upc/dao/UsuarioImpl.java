/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ACER
 */
public class UsuarioImpl implements UsuarioDao{
 
    
    private EntityManagerFactory factoria;
    private EntityManager manager;

    public UsuarioImpl() {
        factoria = Persistence.createEntityManagerFactory("TrabFinalPU");
        manager = factoria.createEntityManager();
    }

    
    
    @Override
    public Usuario login(String nombreusuario, String passwordusuario) {
        
        
        Usuario u = new Usuario();
        List<Usuario> lista = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Usuario u where u.nombreusuario=?1 and u.passwordusuario=?2");
            q.setParameter(1, nombreusuario);
            q.setParameter(2, passwordusuario);
            lista = (List<Usuario>) q.getResultList();
            if (lista != null && !lista.isEmpty()) {
                u = lista.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
    
}
