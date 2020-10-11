/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fact.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Diego
 */
@Controller
@Scope("session")
public class LoginBean implements Serializable {

    /**
     * Creates a new instance of LoginBean
     */
    private String username;
    private String password;

    public LoginBean() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() throws ServletException, IOException {
        String springCheckUrl = this.buildSpringSecurityCheckUrl();
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = ((HttpServletRequest) context.getRequest());
        ServletResponse resposnse = ((ServletResponse) context.getResponse());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
        RequestDispatcher dispatcher = request.getRequestDispatcher(springCheckUrl);
        dispatcher.forward(request, resposnse);
        FacesContext.getCurrentInstance().responseComplete();
        this.setCredenciales();
        return null;
    }

    private String buildSpringSecurityCheckUrl() {
        StringBuilder springCheckUrl = new StringBuilder(
                "/j_spring_security_check").append("?").append("j_username").append("=").append(this.getUsername().trim()).append("&").append("j_password").append("=").append(this.getPassword().trim());
        return springCheckUrl.toString();
    }

    public String logout() throws IOException, ServletException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_logout");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        return "/";
    }

    private void setCredenciales() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            this.setUsername(auth.getName());

        } catch (NullPointerException e) {
        }
    }

    public void preRender(ComponentSystemEvent cse) throws AbortProcessingException {
        Map<String, Object> atributos = cse.getComponent().getAttributes();
        String error = (String) atributos.get("error");
        if (error != null && !"".equals(error)) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage("", new FacesMessage(error));
        }
    }
}
