/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "cticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cticket.findAll", query = "SELECT c FROM Cticket c"),
    @NamedQuery(name = "Cticket.findById", query = "SELECT c FROM Cticket c WHERE c.id = :id"),
    @NamedQuery(name = "Cticket.findByAsunto", query = "SELECT c FROM Cticket c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "Cticket.findByDescripcion", query = "SELECT c FROM Cticket c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cticket.findByCreado", query = "SELECT c FROM Cticket c WHERE c.creado = :creado"),
    @NamedQuery(name = "Cticket.findByCompletado", query = "SELECT c FROM Cticket c WHERE c.completado = :completado")})
public class Cticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "completado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completado;
    @OneToMany(mappedBy = "cticket")
    private Collection<Dticket> dticketCollection;
    @JoinColumn(name = "estado", referencedColumnName = "id")
    @ManyToOne
    private Estados estado;
    @JoinColumn(name = "prioridad", referencedColumnName = "id")
    @ManyToOne
    private Prioridades prioridad;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios usuario;
    @JoinColumn(name = "agente", referencedColumnName = "id")
    @ManyToOne
    private Usuarios agente;

    public Cticket() {
    }

    public Cticket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getCompletado() {
        return completado;
    }

    public void setCompletado(Date completado) {
        this.completado = completado;
    }

    @XmlTransient
    public Collection<Dticket> getDticketCollection() {
        return dticketCollection;
    }

    public void setDticketCollection(Collection<Dticket> dticketCollection) {
        this.dticketCollection = dticketCollection;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Prioridades getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridades prioridad) {
        this.prioridad = prioridad;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Usuarios getAgente() {
        return agente;
    }

    public void setAgente(Usuarios agente) {
        this.agente = agente;
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
        if (!(object instanceof Cticket)) {
            return false;
        }
        Cticket other = (Cticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puntonet.ticketmanagement.entidades.Cticket[ id=" + id + " ]";
    }
    
}
