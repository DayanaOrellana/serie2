package com.empresa.logistica.clientes_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.logistica.clientes_pedidos.model.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
