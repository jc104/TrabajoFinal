/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="Venta")
public class Venta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cventa;
    @Temporal(TemporalType.DATE)
    @Column(name = "dventa", length = 10, nullable = false)
    private Date dventa;
    @Column (name="mtotal",  nullable=false)
    private float mtotal;
    @ManyToOne
    @JoinColumn(name="codigo",nullable=false)
    private Usuario usuario;
    
    public Venta(){}

    public int getCventa() {
        return cventa;
    }

    public void setCventa(int cventa) {
        this.cventa = cventa;
    }

    public Date getDventa() {
        return dventa;
    }

    public void setDventa(Date dventa) {
        this.dventa = dventa;
    }

    public float getMtotal() {
        return mtotal;
    }

    public void setMtotal(float mtotal) {
        this.mtotal = mtotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Venta(int cventa, Date dventa, float mtotal, Usuario usuario) {
        this.cventa = cventa;
        this.dventa = dventa;
        this.mtotal = mtotal;
        this.usuario = usuario;
    }
}
