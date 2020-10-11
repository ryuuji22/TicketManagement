package com.fact.servicios;

import com.fact.dao.PrioridadesDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fact.entidades.Prioridades;
import com.google.common.collect.Lists;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
@Service("PrioridadesService")
@Transactional
public class PrioridadesServiceImpl implements PrioridadesService, Serializable {

    @Autowired
    private PrioridadesDAO prioridadesDAO;

    public PrioridadesServiceImpl() {
    }

    @Override
    public Prioridades findPrioridadById(Integer id) {
        return prioridadesDAO.findOne(id);
    }

    @Override
    public Prioridades insertar(Prioridades estado) {
        return prioridadesDAO.save(estado);
    }

    @Override
    public void eliminar(Prioridades estado) {
        prioridadesDAO.delete(estado);
    }

    @Override
    public List<Prioridades> findAllPrioridades() {
        return Lists.newArrayList(prioridadesDAO.findAll());
    }

}
