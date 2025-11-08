package com.empresa.logistica.proveedores_facturas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.logistica.proveedores_facturas.model.Proveedor;
import com.empresa.logistica.proveedores_facturas.repository.ProveedorRepository;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorRepository.findAll());
        return "proveedores";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        return "redirect:/proveedores";
    }
}
