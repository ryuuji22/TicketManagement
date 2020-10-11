package com.fact.servicios;

import com.fact.entidades.Estados;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
public interface EstadosService {

    public Estados findEstadoById(Integer id);

    public Estados insertar(Estados ticket);

    public void eliminar(Estados ticket);
    
    public List<Estados> findAllEstados();

}
