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
@Table (name="Marca")
public class Marca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cmarca;
    @Column(name = "nmarca",length = 40,nullable = false)
    private  String nmarca;

    public Marca() {
    }

    public Marca(int cmarca, String nmarca) {
        this.cmarca = cmarca;
        this.nmarca = nmarca;
    }

    public int getCmarca() {
        return cmarca;
    }

    public void setCmarca(int cmarca) {
        this.cmarca = cmarca;
    }

    public String getNmarca() {
        return nmarca;
    }

    public void setNmarca(String nmarca) {
        this.nmarca = nmarca;
    }
    
    
            
    
}
