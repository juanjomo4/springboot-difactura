package com.juanjo.curso.springboot.di.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
/*
 * SessionScope se utiliza para indicar que el ciclo de vida del bean está
 * ligado a la sesión HTTP y se destruye al finalizar la sesión.
 * La diferencia entre RequestScope y SessionScope radica en su duración:
 * RequestScope se crea y destruye con cada solicitud HTTP, mientras que
 * SessionScope persiste durante toda la sesión del usuario.
 */
@SessionScope
// @JsonIgnoreProperties({"targetSource","advisors"})
public class Client {
    //Usando @Value para inyectar valores desde el archivo de propiedades
    @Value("${client.name}")
    private String name;
    @Value("${client.lastname}")
    private String lastname;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
