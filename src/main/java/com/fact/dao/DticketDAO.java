/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.dao;

import com.fact.entidades.Dticket;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sistemas
 */
public interface DticketDAO extends CrudRepository<Dticket, Integer> {
    
    @Query("SELECT d FROM Dticket d WHERE d.cticket.id = ?1")
    public List<Dticket> findCticketsByDticket(Integer cticket);

}
