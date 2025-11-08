package com.empresa.logistica.proveedores_facturas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresa.logistica.proveedores_facturas.model.Factura;
import com.empresa.logistica.proveedores_facturas.model.Proveedor;
import com.empresa.logistica.proveedores_facturas.repository.FacturaRepository;
import com.empresa.logistica.proveedores_facturas.repository.ProveedorRepository;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaRepository.findAll());
        return "facturas";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Factura factura, @RequestParam Long proveedorId) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId).orElse(null);
        if (proveedor != null) {
            factura.setProveedor(proveedor);
            facturaRepository.save(factura);
        }
        return "redirect:/facturas";
    }
}
