package com.empresa.logistica.proveedores_facturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.empresa.logistica.proveedores_facturas")
public class ProveedoresFacturasApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProveedoresFacturasApplication.class, args);
    }
}

