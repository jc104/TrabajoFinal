/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Categoria;
import com.upc.entidades.Marca;
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
public class MarcaImpl implements MarcaDao {
    
     private EntityManagerFactory factoria;
    private EntityManager manager;

    public MarcaImpl() {
        factoria = Persistence.createEntityManagerFactory("TrabFinalPU");
        manager = factoria.createEntityManager();
    }
    

    @Override
    public void insertar(Marca marca) {
               try {
            manager.getTransaction().begin();
            manager.persist(marca);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
       
    }

    @Override
    public void eliminar(int cmarca) {
             Marca ma = new Marca();
        try {
            manager.getTransaction().begin();
            ma = manager.getReference(Marca.class, cmarca);
            manager.remove(ma);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Marca marca) {
                try {

            manager.getTransaction().begin();
            manager.merge(marca);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Marca> Listar() {
        List<Marca> lista = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Marca ma");
            lista = (List<Marca>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Marca ListarId(int cmarca) {
                 List<Marca> lista = new ArrayList<>();
        Marca ma = new Marca();
        try {
            ma = manager.find(Marca.class, cmarca);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ma;
    }

    @Override
    public List<Marca> BuscarMarca(String nmarca) {
        List<Marca> listabusqueda = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Marca ma where ma.nmarca like ?1");
            q.setParameter(1, nmarca+"%");
            listabusqueda = (List<Marca>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listabusqueda;
    }

    }
    

