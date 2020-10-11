package com.fact.servicios;

import com.fact.entidades.Prioridades;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
public interface PrioridadesService {

    public Prioridades findPrioridadById(Integer id);

    public Prioridades insertar(Prioridades ticket);

    public void eliminar(Prioridades ticket);
    
    public List<Prioridades> findAllPrioridades();

}
