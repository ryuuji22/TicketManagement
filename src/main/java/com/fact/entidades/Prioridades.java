/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "prioridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridades.findAll", query = "SELECT p FROM Prioridades p"),
    @NamedQuery(name = "Prioridades.findById", query = "SELECT p FROM Prioridades p WHERE p.id = :id"),
    @NamedQuery(name = "Prioridades.findByNombre", query = "SELECT p FROM Prioridades p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Prioridades.findByColor", query = "SELECT p FROM Prioridades p WHERE p.color = :color")})
public class Prioridades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "color")
    private String color;
    @OneToMany(mappedBy = "prioridad")
    private Collection<Cticket> cticketCollection;

    public Prioridades() {
    }

    public Prioridades(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public Collection<Cticket> getCticketCollection() {
        return cticketCollection;
    }

    public void setCticketCollection(Collection<Cticket> cticketCollection) {
        this.cticketCollection = cticketCollection;
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
        if (!(object instanceof Prioridades)) {
            return false;
        }
        Prioridades other = (Prioridades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puntonet.ticketmanagement.entidades.Prioridades[ id=" + id + " ]";
    }
    
}
