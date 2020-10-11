package com.fact.servicios;

import com.fact.dao.EstadosDAO;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fact.entidades.Estados;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
@Service("EstadosService")
@Transactional
public class EstadosServiceImpl implements EstadosService, Serializable {

    @Autowired
    private EstadosDAO estadosDAO;

    public EstadosServiceImpl() {
    }

    @Override
    public Estados findEstadoById(Integer id) {
        return estadosDAO.findOne(id);
    }

    @Override
    public Estados insertar(Estados estado) {
        return estadosDAO.save(estado);
    }

    @Override
    public void eliminar(Estados estado) {
        estadosDAO.delete(estado);
    }

    @Override
    public List<Estados> findAllEstados() {
        return Lists.newArrayList(estadosDAO.findAll());
    }

}
