package com.fact.servicios;

import com.fact.dao.DticketDAO;
import com.fact.entidades.Dticket;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;

/**
 * Spring service that handles CRUD requests for Prov entities
 *
 */
@Service("DticketService")
@Transactional
public class DticketServiceImpl implements DticketService, Serializable {

    @Autowired
    private DticketDAO dticketDAO;

    public DticketServiceImpl() {
    }

    @Override
    public List<Dticket> findAllDtickets() {
        return Lists.newArrayList(dticketDAO.findAll());
    }

    @Override
    public Dticket findDticketById(Integer id) {
        return dticketDAO.findOne(id);
    }

    @Override
    public Dticket insertar(Dticket dticket) {
        return dticketDAO.save(dticket);
    }

    @Override
    public void eliminar(Dticket dticket) {
        dticketDAO.delete(dticket);
    }

    @Override
    public List<Dticket> findCticketsByDticket(Integer cticket) {
        return dticketDAO.findCticketsByDticket(cticket);
    }

}
