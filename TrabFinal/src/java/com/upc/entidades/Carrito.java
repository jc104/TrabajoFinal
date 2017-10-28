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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="Carrito")
public class Carrito implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ccarrito;
    @Temporal(TemporalType.DATE)
    @Column(name = "dfechacarrito", length = 10, nullable = false)
    private Date dfechacarrito;
    @Temporal(TemporalType.TIME)
    @Column(name = "dhora", length = 10, nullable = false)
    private Date dhora;
    
    public Carrito(){}

    public int getCcarrito() {
        return ccarrito;
    }

    public void setCcarrito(int ccarrito) {
        this.ccarrito = ccarrito;
    }

    public Date getDfechacarrito() {
        return dfechacarrito;
    }

    public void setDfechacarrito(Date dfechacarrito) {
        this.dfechacarrito = dfechacarrito;
    }

    public Date getDhora() {
        return dhora;
    }

    public void setDhora(Date dhora) {
        this.dhora = dhora;
    }

    public Carrito(int ccarrito, Date dfechacarrito, Date dhora) {
        this.ccarrito = ccarrito;
        this.dfechacarrito = dfechacarrito;
        this.dhora = dhora;
    }
}
