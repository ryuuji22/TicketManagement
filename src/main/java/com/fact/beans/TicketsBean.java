package com.fact.beans;

import com.fact.beans.util.JsfUtil;
import com.fact.entidades.Cticket;
import com.fact.entidades.Dticket;
import com.fact.entidades.Estados;
import com.fact.entidades.Prioridades;
import com.fact.entidades.Usuarios;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.fact.servicios.CticketService;
import com.fact.servicios.DticketService;
import com.fact.servicios.EstadosService;
import com.fact.servicios.PrioridadesService;
import com.fact.servicios.UsuariosService;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

/**
 *
 * @author
 */
@Controller
@Scope("session")
public class TicketsBean extends GenericBean<Cticket> implements Serializable {

    @Autowired
    private CticketService cticketService;

    @Autowired
    private DticketService dticketService;

    @Autowired
    private PrioridadesService prioridadesService;
    
    @Autowired
    private EstadosService estadosService;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private LoginBean loginBean;

    private List<Prioridades> prioridades;
    private List<Estados> estados;
    private List<Usuarios> agentes;
    private List<Usuarios> escalateAgents;
    private List<Dticket> comentarios;
    private List<Cticket> filteredTickets;
    private Integer prioridadID;
    private Integer agenteID;
    private Usuarios usuarioLogin;
    private String comentario;

    public TicketsBean() {
        super(Cticket.class);

    }

    @PostConstruct
    private void inicializarValores() {
        usuarioLogin = usuariosService.findUsuarioByUsername(loginBean.getUsername());
    }

    @Override
    public void persist(PersistAction persistAction, String successMessage) {
        if (this.getSelected() != null) {
            try {
                if (persistAction != TicketsBean.PersistAction.CLOSE) {
                    if (null != persistAction) {
                        switch (persistAction) {
                            case CREATE: {
                                Date ahora = new Date();
                                Usuarios agente = new Usuarios(getAgenteID());
                                Estados estado = new Estados(1);
                                Prioridades prioridad = new Prioridades(getPrioridadID());
                                this.getSelected().setUsuario(usuarioLogin);
                                this.getSelected().setAgente(agente);
                                this.getSelected().setEstado(estado);
                                this.getSelected().setPrioridad(prioridad);
                                this.getSelected().setCreado(ahora);
                                cticketService.insertar(this.getSelected());
                                break;
                            }
                            case ESCALATE: {
                                Usuarios agente = new Usuarios(getAgenteID());
                                this.getSelected().setAgente(agente);
                                this.getSelected().setEstado(new Estados(3));
                                cticketService.insertar(this.getSelected());
                                break;
                            }
                            case COMMENT:
                                Dticket comentarioTicket = new Dticket();
                                comentarioTicket.setComentario(getComentario());
                                comentarioTicket.setCreado(new Date());
                                comentarioTicket.setUsuario(getUsuarioLogin());
                                comentarioTicket.setCticket(getSelected());
                                dticketService.insertar(comentarioTicket);
                                this.resetValuesComments();
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    Date fechaCompletado = new Date();
                    this.getSelected().setCompletado(fechaCompletado);
                    this.getSelected().setEstado(new Estados(2));
                    cticketService.insertar(this.getSelected());
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = JsfUtil.getRootCause(ex.getCause());
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex.getMessage());
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex.getMessage());
            }
        }
    }

    @Override
    public List<Cticket> getItems() {
        if (items == null) {
            items = cticketService.findAllCtickets(getUsuarioLogin().getUsername());
        }
        return items;
    }

    public Usuarios getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuarios usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public List<Cticket> getFilteredTickets() {
        return filteredTickets;
    }

    public void setFilteredTickets(List<Cticket> filteredTickets) {
        this.filteredTickets = filteredTickets;
    }

    public Integer getPrioridadID() {
        return prioridadID;
    }

    public void setPrioridadID(Integer prioridadID) {
        this.prioridadID = prioridadID;
    }

    public Integer getAgenteID() {
        return agenteID;
    }

    public void setAgenteID(Integer agenteID) {
        this.agenteID = agenteID;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Prioridades> getPrioridades() {
        if (prioridades == null) {
            prioridades = prioridadesService.findAllPrioridades();
        }
        return prioridades;
    }

    public void setPrioridades(List<Prioridades> prioridades) {
        this.prioridades = prioridades;
    }

    public List<Estados> getEstados() {
         if (estados == null) {
            estados = estadosService.findAllEstados();
        }
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }
    
    

    public List<Usuarios> getAgentes() {
        if (agentes == null) {
            agentes = usuariosService.findAllAgentes();
        }
        return agentes;
    }

    public void setAgentes(List<Usuarios> agentes) {
        this.agentes = agentes;
    }

    public List<Usuarios> getEscalateAgents() {
        if (escalateAgents == null) {
            escalateAgents = usuariosService.findAllAgentesEscalate(getSelected().getAgente());
        }
        return escalateAgents;
    }

    public void setEscalateAgents(List<Usuarios> escalateAgents) {
        this.escalateAgents = escalateAgents;
    }

    public List<Dticket> getComentarios() {
        if (comentarios == null) {
            if (this.getSelected() != null) {
                comentarios = dticketService.findCticketsByDticket(this.getSelected().getId());
            }
        }
        return comentarios;
    }

    public void setComentarios(List<Dticket> comentarios) {
        this.comentarios = comentarios;
    }

    public void escalar(ActionEvent event) {
        String msg = "TICKET ESCALADO";
        persist(PersistAction.ESCALATE, msg);
    }

    public void resetValuesCreate() {
        this.setSelected(null);
        this.setAgenteID(null);
        this.setPrioridadID(null);
    }

    public void resetValuesComments() {
        this.setComentario(null);
        this.setComentarios(null);
    }

    public void resetValuesEscalate() {
        this.setAgenteID(null);
    }

    public void prepareComment() {
        this.setComentarios(null);
    }

}
