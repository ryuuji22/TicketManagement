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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByAgente", query = "SELECT u FROM Usuarios u WHERE u.agente = :agente")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "username")
    private String username;
    @Size(max = 2147483647)
    @Column(name = "password")
    private String password;
    @Column(name = "usuario")
    private Boolean usuario;
    @Column(name = "agente")
    private Boolean agente;
    @OneToMany(mappedBy = "usuario")
    private Collection<Dticket> dticketCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<Cticket> cticketCollection;
    @OneToMany(mappedBy = "agente")
    private Collection<Cticket> cticketCollection1;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUsuario() {
        return usuario;
    }

    public void setUsuario(Boolean usuario) {
        this.usuario = usuario;
    }

    public Boolean getAgente() {
        return agente;
    }

    public void setAgente(Boolean agente) {
        this.agente = agente;
    }

    @XmlTransient
    public Collection<Dticket> getDticketCollection() {
        return dticketCollection;
    }

    public void setDticketCollection(Collection<Dticket> dticketCollection) {
        this.dticketCollection = dticketCollection;
    }

    @XmlTransient
    public Collection<Cticket> getCticketCollection() {
        return cticketCollection;
    }

    public void setCticketCollection(Collection<Cticket> cticketCollection) {
        this.cticketCollection = cticketCollection;
    }

    @XmlTransient
    public Collection<Cticket> getCticketCollection1() {
        return cticketCollection1;
    }

    public void setCticketCollection1(Collection<Cticket> cticketCollection1) {
        this.cticketCollection1 = cticketCollection1;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puntonet.ticketmanagement.entidades.Usuarios[ id=" + id + " ]";
    }
    
}
