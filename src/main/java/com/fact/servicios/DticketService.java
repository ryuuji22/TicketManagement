package com.fact.servicios;

import com.fact.entidades.Dticket;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
public interface DticketService {

    public Dticket findDticketById(Integer id);

    public Dticket insertar(Dticket ticket);

    public void eliminar(Dticket ticket);

    public List<Dticket> findAllDtickets();

    public List<Dticket> findCticketsByDticket(Integer cticket);

}
