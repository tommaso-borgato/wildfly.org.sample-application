package org.wildfly.examples;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;

import java.io.Serializable;

@SessionScoped
public class GettingStartedService implements Serializable {

    @Inject
    private HttpServletRequest httpRequest;

    public String hello(String name) {
        System.out.println("Previous name: " + httpRequest.getSession().getAttribute("NAME_PARAMETER"));
        httpRequest.getSession().setAttribute("NAME_PARAMETER", name);
        return String.format("Hello '%s'.", name);
    }
}