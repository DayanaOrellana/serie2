package com.empresa.logistica.clientes_pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.empresa.logistica")
@EntityScan(basePackages = "com.empresa.logistica.model")
@EnableJpaRepositories(basePackages = "com.empresa.logistica.clientes_pedidos.repository")
public class ClientesPedidosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientesPedidosApplication.class, args);
    }
}
