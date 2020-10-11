package com.fact.beans;

import com.fact.beans.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;

public abstract class GenericBean<T> implements Serializable {

    private Class<T> itemClass;
    private T selected;
    protected List<T> items;
    private List<T> filtered;

    public enum PersistAction {

        CREATE,
        CLOSE,
        UPDATE,
        ESCALATE,
        COMMENT
    }

    public GenericBean(Class<T> itemClass) {
        this.itemClass = itemClass;

    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public List<T> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<T> filtered) {
        this.filtered = filtered;
    }

    protected void setEmbeddableKeys() {
        // Nothing to do if entity does not have any embeddable key.
    }

    protected void initializeEmbeddableKey() {
        // Nothing to do if entity does not have any embeddable key.
    }

    public abstract List<T> getItems();

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void save(ActionEvent event) {
        String msg = "Ticket actualizado";
        persist(PersistAction.ESCALATE, msg);
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
            selected=null;
        }
    }
    
    public void saveComment(ActionEvent event) {
        String msg = "Comentario enviado";
        persist(PersistAction.COMMENT, msg);
  
    }

    public void saveNew(ActionEvent event) {
        System.err.println(itemClass.getSimpleName() + "Created");
        String msg = "Ticket creado";
        persist(PersistAction.CREATE, msg);
        if (!isValidationFailed()) {
            items = null; // Invalidate list of items to trigger re-query.
            selected=null;
        }
    }

    public void close(ActionEvent event) {
        String msg = "Ticket Cerrado";
        persist(PersistAction.CLOSE, msg);
        if (!isValidationFailed()) {
            selected = null; // Remove selection
            items = null; // Invalidate list of items to trigger re-query.
        }
    }

    public abstract void persist(GenericBean.PersistAction persistAction, String successMessage);

    /**
     * Creates a new instance of an underlying entity and assigns it to Selected
     * property.
     *
     * @return
     */
    public T prepareCreate(ActionEvent event) {
        T newItem;

        try {
            newItem = itemClass.newInstance();
            this.selected = newItem;
            initializeEmbeddableKey();
            return newItem;
        } catch (InstantiationException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isValidationFailed() {
        return JsfUtil.isValidationFailed();
    }
}
