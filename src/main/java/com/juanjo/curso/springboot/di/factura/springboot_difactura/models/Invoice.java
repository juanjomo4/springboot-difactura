package com.juanjo.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
/*
 * RequestScope se utiliza para indicar que el ciclo de vida del bean está
 * ligado a la solicitud HTTP y se destruye al finalizar la solicitud.
 * La diferencia entre RequestScope y SessionScope radica en su duración:
 * RequestScope se crea y destruye con cada solicitud HTTP, mientras que
 * SessionScope persiste durante toda la sesión del usuario.
 */
@RequestScope
// @JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {

    @Autowired
    private Client client;

    // Usando @Value para inyectar valores desde el archivo de propiedades
    // @Value("${invoice.description.office}")
    @Value("${invoice.description}")
    private String description;
    @Autowired
    @Qualifier("default")
    private List<Item> items;

    /*
     * PostConstruct se utiliza para indicar que este método debe ser ejecutado
     * después de que se haya completado la inyección de dependencias.
     */
    @PostConstruct
    public void init() {
        System.out.println("Factura inicializada");
    }

    /*
     * PreDestroy se utiliza para indicar que este método debe ser ejecutado
     * antes de que el bean sea destruido.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Factura destruida");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Método que calcula el total de la factura para mostrarlo en el JSON como
    // "totalInvoice"
    public double getTotalInvoice() {

        // Forma tradicional de sumar los importes
        // double total = 0.0;
        // for (Item item : items) {
        // total += item.getImporte();
        // }

        // Una forma de sumar los importes usando streams y el método reduce()
        double total = items.stream()
                .map(item -> item.getImporte())
                .reduce(0.0, (suma, item) -> suma + item);
        return total;
    }

}
