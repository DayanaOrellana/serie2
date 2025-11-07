package com.empresa.logistica.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference  // 👈 evita recursión inversa
    private Cliente cliente;

    public Pedido() {}

    public Pedido(String producto, int cantidad, Cliente cliente) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cliente = cliente;
    }

    public Long getId() { return id; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}


