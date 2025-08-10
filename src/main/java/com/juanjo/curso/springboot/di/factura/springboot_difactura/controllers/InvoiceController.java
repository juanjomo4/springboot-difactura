package com.juanjo.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanjo.curso.springboot.di.factura.springboot_difactura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    // Inyectar la factura
    @Autowired
    private Invoice invoice;

    // Mostrar la factura
    @GetMapping("show")
    public Invoice show() {
        return invoice;
    }
}
