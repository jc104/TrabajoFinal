/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.entidades;

/**
 *
 * @author ACER
 */
public class Marca {
    
    private int cmarca;
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
