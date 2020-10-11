/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facti.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Diego
 */
public class LoginFilter implements Filter {

    private FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;
        String pageRequested = httprequest.getRequestURL().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = null;
        if (auth != null) {
            name = auth.getName(); //get logged in username
            if (name.equalsIgnoreCase("anonymousUser")) {
                name = null;
            }
        }
        httpresponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpresponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        httpresponse.setDateHeader("Expires", 0); // Proxies.
        try {
            if (name != null && pageRequested.contains("/login.xhtml")) {

                System.out.printf("User authenticated with " + httprequest.getRemoteUser() + " username conected.");
                httprequest.getRequestDispatcher("/index.xhtml").forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            //do something
        }

    }

    @Override
    public void destroy() {
        System.out.print("Existing from loginFilter");
    }
}
