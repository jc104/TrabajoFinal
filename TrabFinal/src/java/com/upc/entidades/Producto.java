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
@Table (name="Producto")
public class Producto implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cproducto;
    @Column (name="nproducto", length=40, nullable=false)
    private String nproducto;
    @Column (name="stock",  nullable=false)
    private int stock;
    @ManyToOne
    @JoinColumn(name="ccategoria",nullable=false)
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name="cmarca",nullable=false)
    private Marca marca;
    
    
    public Producto(){}

    public int getCproducto() {
        return cproducto;
    }

    public void setCproducto(int cproducto) {
        this.cproducto = cproducto;
    }

    public String getNproducto() {
        return nproducto;
    }

    public void setNproducto(String nproducto) {
        this.nproducto = nproducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Producto(int cproducto, String nproducto, int stock, Categoria categoria, Marca marca) {
        this.cproducto = cproducto;
        this.nproducto = nproducto;
        this.stock = stock;
        this.categoria = categoria;
        this.marca = marca;
    }
}
