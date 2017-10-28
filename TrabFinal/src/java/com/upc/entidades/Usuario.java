package com.upc.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo", nullable = false)
    private Persona persona;

    @Column(name = "nombreusuario", nullable = false)
    private String nombreusuario;

    @Column(name = "passwordusuario", nullable = false)
    private String passwordusuario;

    public Usuario() {
    }

    public Usuario(Persona persona, String nombreusuario, String passwordusuario) {
        this.persona = persona;
        this.nombreusuario = nombreusuario;
        this.passwordusuario = passwordusuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPasswordusuario() {
        return passwordusuario;
    }

    public void setPasswordusuario(String passwordusuario) {
        this.passwordusuario = passwordusuario;
    }

}
