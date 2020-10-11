/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao;

import com.fact.entidades.Cticket;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sistemas
 */
public interface CticketDAO extends CrudRepository<Cticket, Integer> {

    @Query("SELECT t FROM Cticket t WHERE t.agente.username = ?1")
    public List<Cticket> findCticketsByAgente(String agente);

    @Query("SELECT t FROM Cticket t WHERE t.usuario.username = ?1")
    public List<Cticket> findCticketsByUsuario(String usuario);

    @Query("SELECT t FROM Cticket t WHERE t.usuario.username = ?1 OR t.agente.username = ?1")
    public List<Cticket> findCticketsByUsuarioAndAgent(String usuario);

}
