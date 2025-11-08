package com.empresa.logistica.proveedores_facturas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.logistica.proveedores_facturas.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {}
