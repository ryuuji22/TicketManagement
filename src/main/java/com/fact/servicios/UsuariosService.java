package com.fact.servicios;

import com.fact.entidades.Usuarios;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
public interface UsuariosService {
    
    public List<Usuarios> findAllAgentes();
    
    public Usuarios findUsuarioByUsername(String username);
    
    public List<Usuarios> findAllAgentesEscalate(Usuarios agente);

}
