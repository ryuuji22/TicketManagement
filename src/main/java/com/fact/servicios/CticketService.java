package com.fact.servicios;

import com.fact.entidades.Cticket;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
public interface CticketService {

    public Cticket findCticketById(Integer id);

    public Cticket insertar(Cticket ticket);

    public void eliminar(Cticket ticket);
    
    public List<Cticket> findAllCtickets(String usuario);
    

}
