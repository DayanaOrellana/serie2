package com.empresa.logistica.clientes_pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresa.logistica.clientes_pedidos.model.Cliente;
import com.empresa.logistica.clientes_pedidos.model.Pedido;
import com.empresa.logistica.clientes_pedidos.repository.ClienteRepository;
import com.empresa.logistica.clientes_pedidos.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // ✅ Mostrar lista de pedidos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedido", new Pedido()); // 👈 necesario para el formulario
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "pedidos";
    }

    // ✅ Guardar nuevo pedido
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pedido pedido, @RequestParam Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente != null) {
            pedido.setCliente(cliente);
            pedidoRepository.save(pedido);
        }
        return "redirect:/pedidos";
    }
}

