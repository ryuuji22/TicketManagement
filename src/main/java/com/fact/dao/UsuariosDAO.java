/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao;

import com.fact.entidades.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sistemas
 */
public interface UsuariosDAO extends CrudRepository<Usuarios, Integer> {

    @Query("SELECT u FROM Usuarios u WHERE u.agente = ?1")
    public List<Usuarios> findAgentes(Boolean agente);
    
    @Query("SELECT u FROM Usuarios u WHERE u.username = ?1")
    public Usuarios findUsuarioByUsername(String username);
    
    @Query("SELECT u FROM Usuarios u WHERE u.id != ?1 and u.agente = true")
    public List<Usuarios>findUsuariosNorAgent(Integer id);
}
