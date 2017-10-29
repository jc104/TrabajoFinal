/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.dao;

import com.upc.entidades.Carrito;
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
public class CarritoImpl implements CarritoDao {

    private EntityManagerFactory factoria;
    private EntityManager manager;

    public CarritoImpl() {
        factoria = Persistence.createEntityManagerFactory("TrabFinalPU");
        manager = factoria.createEntityManager();
    }

    @Override
    public void insertar(Carrito carrito) {
        try {
            manager.getTransaction().begin();
            manager.persist(carrito);
            manager.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int ccarrito) {
        Carrito car = new Carrito();
        try {
            manager.getTransaction().begin();
            car = manager.getReference(Carrito.class, ccarrito);
            manager.remove(car);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Carrito carrito) {
        try {

            manager.getTransaction().begin();
            manager.merge(carrito);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Carrito> Listar() {
        List<Carrito> lista = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Carrito car");
            lista = (List<Carrito>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Carrito ListarId(int ccarrito) {
        List<Carrito> lista = new ArrayList<>();
        Carrito car = new Carrito();
        try {
            car = manager.find(Carrito.class, ccarrito);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return car;
    }

    //Revisar la busqueda
    @Override
    public List<Carrito> BuscarCarrito(String ncarrito) {
        List<Carrito> listabusqueda = new ArrayList<>();
        try {
            Query q = manager.createQuery("from Carrito car where car.producto.nproducto like ?1 ");
                
            q.setParameter(1, "%" + ncarrito + "%");
          

            listabusqueda = (List<Carrito>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listabusqueda;
    }

}
