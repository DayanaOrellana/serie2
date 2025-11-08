package com.empresa.logistica.proveedores_facturas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.logistica.proveedores_facturas.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {}
