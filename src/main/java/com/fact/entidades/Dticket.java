/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "dticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dticket.findAll", query = "SELECT d FROM Dticket d"),
    @NamedQuery(name = "Dticket.findById", query = "SELECT d FROM Dticket d WHERE d.id = :id"),
    @NamedQuery(name = "Dticket.findByComentario", query = "SELECT d FROM Dticket d WHERE d.comentario = :comentario"),
    @NamedQuery(name = "Dticket.findByCreado", query = "SELECT d FROM Dticket d WHERE d.creado = :creado")})
public class Dticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @JoinColumn(name = "cticket", referencedColumnName = "id")
    @ManyToOne
    private Cticket cticket;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios usuario;

    public Dticket() {
    }

    public Dticket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Cticket getCticket() {
        return cticket;
    }

    public void setCticket(Cticket cticket) {
        this.cticket = cticket;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dticket)) {
            return false;
        }
        Dticket other = (Dticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puntonet.ticketmanagement.entidades.Dticket[ id=" + id + " ]";
    }
    
}
