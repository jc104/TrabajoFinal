/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author LUIS-HP
 */
public class CategoriaImpl implements CategoriaDao {

    private EntityManagerFactory factoria;
    private EntityManager manager;

    public CategoriaImpl() {
        factoria = Persistence.createEntityManagerFactory("TrabFinalPU");
        manager = factoria.createEntityManager();
    }
    
    @Override
    public void insertar(Categoria categoria) {
        
           try {
            manager.getTransaction().begin();
            manager.persist(categoria);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void eliminar(int ccategoria) {
         Categoria cat = new Categoria();
        try {
            manager.getTransaction().begin();
            cat = manager.getReference(Categoria.class, ccategoria);
            manager.remove(cat);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Categoria categoria) {
            try {

            manager.getTransaction().begin();
            manager.merge(categoria);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Categoria> Listar() {
               List<Categoria> lista = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Categoria ca");
            lista = (List<Categoria>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Categoria ListarId(int ccategoria) {
               List<Categoria> lista = new ArrayList<>();
        Categoria cat = new Categoria();
        try {
            cat = manager.find(Categoria.class, ccategoria);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cat;
    }

    @Override
    public List<Categoria> BuscarCategoria(String ncategoria) {
                 List<Categoria> listabusqueda = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Categoria ca where ca.ncategoria like ?1");
            q.setParameter(1, ncategoria+"%");
            listabusqueda = (List<Categoria>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listabusqueda;
    }
    }
    

