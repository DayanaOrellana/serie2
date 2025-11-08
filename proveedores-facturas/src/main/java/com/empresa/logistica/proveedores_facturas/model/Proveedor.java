package com.empresa.logistica.proveedores_facturas.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String empresa;
    private String correo;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Proveedor() {}

    public Proveedor(String nombre, String empresa, String correo) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.correo = correo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}

