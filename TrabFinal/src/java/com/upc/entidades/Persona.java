package com.upc.entidades;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigopersona;

    @Column(name = "dnipersona", length = 8, nullable = false)
    private String dnipersona;

    @Column(name = "nombrepersona", length = 40, nullable = false)
    private String nombrepersona;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechanacimientopersona", length = 10, nullable = false)
    private Date fechanacimientopersona;
    
    @Column(name = "emailpersona", length = 50)
    private String emailpersona;
    
    @Column(name = "direccionpersona",length=50)
    private String direccionpersona;
    
    @Column(name = "telefonopersona",length=25)
    private String telefonopersona;
    
    @Transient
    private String fechaFormateada;

    public Persona() {
    }

    public Persona(int codigopersona, String dnipersona, String nombrepersona, Date fechanacimientopersona, String emailpersona, String direccionpersona, String telefonopersona) {
        this.codigopersona = codigopersona;
        this.dnipersona = dnipersona;
        this.nombrepersona = nombrepersona;
        this.fechanacimientopersona = fechanacimientopersona;
        this.emailpersona = emailpersona;
        this.direccionpersona = direccionpersona;
        this.telefonopersona = telefonopersona;
    }

    public int getCodigopersona() {
        return codigopersona;
    }

    public void setCodigopersona(int codigopersona) {
        this.codigopersona = codigopersona;
    }

    public String getDnipersona() {
        return dnipersona;
    }

    public void setDnipersona(String dnipersona) {
        this.dnipersona = dnipersona;
    }

    public String getNombrepersona() {
        return nombrepersona;
    }

    public void setNombrepersona(String nombrepersona) {
        this.nombrepersona = nombrepersona;
    }

    public Date getFechanacimientopersona() {
        return fechanacimientopersona;
    }

    public void setFechanacimientopersona(Date fechanacimientopersona) {
        this.fechanacimientopersona = fechanacimientopersona;
    }

    public String getEmailpersona() {
        return emailpersona;
    }

    public void setEmailpersona(String emailpersona) {
        this.emailpersona = emailpersona;
    }

    public String getDireccionpersona() {
        return direccionpersona;
    }

    public void setDireccionpersona(String direccionpersona) {
        this.direccionpersona = direccionpersona;
    }

    public String getTelefonopersona() {
        return telefonopersona;
    }

    public void setTelefonopersona(String telefonopersona) {
        this.telefonopersona = telefonopersona;
    }

    public void setFechaFormateada(String fechaFormateada) {
        this.fechaFormateada = fechaFormateada;
    }

    public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.fechanacimientopersona);
    }

    
}
