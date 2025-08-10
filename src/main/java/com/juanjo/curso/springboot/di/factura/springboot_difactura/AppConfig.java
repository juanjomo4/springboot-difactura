package com.juanjo.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.juanjo.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.juanjo.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties",encoding = "UTF-8")
public class AppConfig {

    // Método que devuelve una lista de ítems para la factura
    // Bean se utiliza para indicar que este
    // método devuelve un objeto que debe ser gestionado
    // por el contenedor de Spring
    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara Sony", 800.0);
        Product p2 = new Product("Laptop Dell", 1200.0);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }
}
