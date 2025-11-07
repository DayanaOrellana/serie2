package com.empresa.logistica.clientes_pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.empresa.logistica.clientes_pedidos.repository.ClienteRepository;
import com.empresa.logistica.clientes_pedidos.repository.PedidoRepository;

@Controller
public class WebController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "index"; // Carga el archivo index.html
    }
}

