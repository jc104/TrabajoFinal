/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Producto;
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
public class ProductoImpl implements ProductoDao{
    
    private EntityManagerFactory factoria;
    private EntityManager manager;

    public ProductoImpl() {
        factoria = Persistence.createEntityManagerFactory("TrabFinalPU");
        manager = factoria.createEntityManager();
    }

    @Override
    public void insertar(Producto producto) {
                try {
            manager.getTransaction().begin();
            manager.persist(producto);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int cproducto) {
        Producto pro = new Producto();
        try {
            manager.getTransaction().begin();
            pro = manager.getReference(Producto.class, cproducto);
            manager.remove(pro);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Producto producto) {
           try {

            manager.getTransaction().begin();
            manager.merge(producto);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Producto> Listar() {
               List<Producto> lista = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Producto pro");
            lista = (List<Producto>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Producto ListarId(int cproducto) {
        List<Producto> lista = new ArrayList<>();
        Producto pro = new Producto();
        try {
            pro = manager.find(Producto.class, cproducto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pro;
    }

    @Override
    public List<Producto> BuscarProducto(String nproducto) {
            List<Producto> listabusqueda = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Producto pro where pro.nproducto like ?1");
            q.setParameter(1, nproducto + "%");
            listabusqueda = (List<Producto>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listabusqueda;
    }

    @Override
    public List<Producto> BuscarTodo(String nproducto) {
         List<Producto> listabusqueda = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Producto pro where pro.nproducto like ?1 "
                    + "or pro.categoria.ncategoria like ?2 "
                    + "or pro.marca.nmarca like ?3 ");
            
            q.setParameter(1, "%" + nproducto + "%");
            q.setParameter(2, "%" + nproducto + "%");
            q.setParameter(3, "%" + nproducto + "%");
       
            listabusqueda = (List<Producto>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listabusqueda;
    }
    }
    

