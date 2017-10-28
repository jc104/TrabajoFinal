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
import javax.persistence.Table;

@Entity
@Table (name="Categoria")
   

public class Categoria implements Serializable {
      
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ccategoria;
    @Column (name="ncategoria",length=40,nullable=false)
    private String ncategoria;
    @Column(name = "tdescripcion",length = 40,nullable = false)
    private String tdescripcion;
    
    
    public Categoria(){}

    public Categoria(int ccategoria, String ncategoria, String tdescripcion) {
        this.ccategoria = ccategoria;
        this.ncategoria = ncategoria;
        this.tdescripcion = tdescripcion;
}

    public int getCcategoria() {
        return ccategoria;
    }

    public void setCcategoria(int ccategoria) {
        this.ccategoria = ccategoria;
    }

    public String getNcategoria() {
        return ncategoria;
    }

    public void setNcategoria(String ncategoria) {
        this.ncategoria = ncategoria;
    }

    public String getTdescripcion() {
        return tdescripcion;
    }

    public void setTdescripcion(String tdescripcion) {
        this.tdescripcion = tdescripcion;
    }
    
  
    
}   
