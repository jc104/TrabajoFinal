/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="DetalleVenta")
public class DetalleVenta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cdetalleventa;
    @Column (name="qcantidad",  nullable=false)
    private int qcantidad;
    @Column (name="mvalorunitario",  nullable=false)
    private float mvalorunitario;
    @Column (name="msubtotal",  nullable=false)
    private float msubtotal;
    @ManyToOne
    @JoinColumn(name="cproducto",nullable=false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name="cventa",nullable=false)
    private Venta venta;
    
    public DetalleVenta(){}

    public int getCdetalleventa() {
        return cdetalleventa;
    }

    public void setCdetalleventa(int cdetalleventa) {
        this.cdetalleventa = cdetalleventa;
    }

    public int getQcantidad() {
        return qcantidad;
    }

    public void setQcantidad(int qcantidad) {
        this.qcantidad = qcantidad;
    }

    public float getMvalorunitario() {
        return mvalorunitario;
    }

    public void setMvalorunitario(float mvalorunitario) {
        this.mvalorunitario = mvalorunitario;
    }

    public float getMsubtotal() {
        return msubtotal;
    }

    public void setMsubtotal(float msubtotal) {
        this.msubtotal = msubtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public DetalleVenta(int cdetalleventa, int qcantidad, float mvalorunitario, float msubtotal, Producto producto, Venta venta) {
        this.cdetalleventa = cdetalleventa;
        this.qcantidad = qcantidad;
        this.mvalorunitario = mvalorunitario;
        this.msubtotal = msubtotal;
        this.producto = producto;
        this.venta = venta;
    }
}
