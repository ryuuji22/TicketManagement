package com.fact.servicios;

import com.fact.dao.UsuariosDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fact.entidades.Usuarios;
import com.google.common.collect.Lists;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
@Service("UsuariosService")
@Transactional
public class UsuariosServiceImpl implements UsuariosService, Serializable {

    @Autowired
    private UsuariosDAO usuariosDAO;

    public UsuariosServiceImpl() {
    }

    @Override
    public List<Usuarios> findAllAgentes() {
        return Lists.newArrayList(usuariosDAO.findAgentes(Boolean.TRUE));
    }

    @Override
    public Usuarios findUsuarioByUsername(String username) {
        return usuariosDAO.findUsuarioByUsername(username);
    }
    
    @Override
    public List<Usuarios> findAllAgentesEscalate(Usuarios agente){
        return usuariosDAO.findUsuariosNorAgent(agente.getId());
    }

}
