/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.DetalleVenta;
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
public class DetalleVentaImpl implements DetalleVentaDao {

    private EntityManagerFactory factoria;
    private EntityManager manager;

    public DetalleVentaImpl() {
        factoria = Persistence.createEntityManagerFactory("TrabFinalPU");
        manager = factoria.createEntityManager();
    }

    @Override
    public void insertar(DetalleVenta detalleventa) {
        try {
            manager.getTransaction().begin();
            manager.persist(detalleventa);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int cdetalleventa) {
        DetalleVenta det = new DetalleVenta();
        try {
            manager.getTransaction().begin();
            det = manager.getReference(DetalleVenta.class, cdetalleventa);
            manager.remove(det);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(DetalleVenta detalleventa) {
        try {

            manager.getTransaction().begin();
            manager.merge(detalleventa);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<DetalleVenta> Listar() {
        List<DetalleVenta> lista = new ArrayList<>();
        try {
            Query q = manager.createQuery("from DetalleVenta det");
            lista = (List<DetalleVenta>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public DetalleVenta ListarId(int cdetalleventa) {
        List<DetalleVenta> lista = new ArrayList<>();
        DetalleVenta det = new DetalleVenta();
        try {
            det = manager.find(DetalleVenta.class, cdetalleventa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return det;
    }

}
