package com.empresa.logistica.proveedores_facturas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresa.logistica.proveedores_facturas.model.Factura;
import com.empresa.logistica.proveedores_facturas.repository.FacturaRepository;
import com.empresa.logistica.proveedores_facturas.repository.ProveedorRepository;

@Controller
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/facturas")
    public String mostrarFacturas(Model model) {
        List<Factura> facturas = facturaRepository.findAll();
        model.addAttribute("facturas", facturas);

        // ✅ Esta línea es la que faltaba
        model.addAttribute("factura", new Factura());

        return "facturas";
    }

    @PostMapping("/facturas/guardar")
public String guardarFactura(@ModelAttribute Factura factura,
                             @RequestParam("proveedorId") Long proveedorId) {
    factura.setProveedor(proveedorRepository.findById(proveedorId).orElse(null));
    facturaRepository.save(factura);
    return "redirect:/facturas";
}

}