/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Venta;
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
public class VentaImpl implements VentaDao {

    private EntityManagerFactory factoria;
    private EntityManager manager;

    public VentaImpl() {
        factoria = Persistence.createEntityManagerFactory("TrabFinalPU");
        manager = factoria.createEntityManager();
    }

    @Override
    public void insertar(Venta venta) {
        try {
            manager.getTransaction().begin();
            manager.persist(venta);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int cventa) {
        Venta ve = new Venta();
        try {
            manager.getTransaction().begin();
            ve = manager.getReference(Venta.class, cventa);
            manager.remove(ve);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Venta venta) {
        try {

            manager.getTransaction().begin();
            manager.merge(venta);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Venta> Listar() {
        List<Venta> lista = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Venta ve");
            lista = (List<Venta>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Venta ListarId(int cventa) {
        List<Venta> lista = new ArrayList<>();
        Venta ve = new Venta();
        try {
            ve = manager.find(Venta.class, cventa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ve;
    }

}
