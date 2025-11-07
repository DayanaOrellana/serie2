package com.empresa.logistica.clientes_pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.empresa.logistica.clientes_pedidos")
public class ClientesPedidosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientesPedidosApplication.class, args);
    }
}

