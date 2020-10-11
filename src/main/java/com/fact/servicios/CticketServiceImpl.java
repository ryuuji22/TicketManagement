package com.fact.servicios;

import com.fact.dao.CticketDAO;
import com.fact.dao.UsuariosDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fact.entidades.Cticket;
import com.fact.entidades.Usuarios;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
@Service("CticketService")
@Transactional
public class CticketServiceImpl implements CticketService, Serializable {

    @Autowired
    private CticketDAO cticketDAO;
    @Autowired
    private UsuariosDAO usuariosDAO;

    public CticketServiceImpl() {
    }

    @Override
    public List<Cticket> findAllCtickets(String usuario) {
        Usuarios usuarioOagente = usuariosDAO.findUsuarioByUsername(usuario);
        if (usuarioOagente.getUsuario()) {
            if(usuarioOagente.getAgente()){
                return Lists.newArrayList(cticketDAO.findCticketsByUsuarioAndAgent(usuario));
            }else{
                return Lists.newArrayList(cticketDAO.findCticketsByUsuario(usuario));
            }
        } else {
            if (usuarioOagente.getAgente()) {
                return Lists.newArrayList(cticketDAO.findCticketsByAgente(usuario));
            } else {
                return new ArrayList<>();
            }
        }

    }

    @Override
    public Cticket findCticketById(Integer id) {
        return cticketDAO.findOne(id);
    }

    @Override
    public Cticket insertar(Cticket producto) {
        return cticketDAO.save(producto);
    }

    @Override
    public void eliminar(Cticket producto) {
        cticketDAO.delete(producto);
    }

}
