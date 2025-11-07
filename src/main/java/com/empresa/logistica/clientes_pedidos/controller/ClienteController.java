package com.empresa.logistica.clientes_pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.empresa.logistica.clientes_pedidos.model.Cliente;
import com.empresa.logistica.clientes_pedidos.model.Pedido;
import com.empresa.logistica.clientes_pedidos.repository.ClienteRepository;
import com.empresa.logistica.clientes_pedidos.repository.PedidoRepository;

@Controller
public class ClienteController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Mostrar lista de pedidos
    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        model.addAttribute("pedido", new Pedido());
        return "pedidos";
    }

    // Guardar pedido desde el formulario
    @PostMapping("/pedidos/guardar")
    public String guardarPedido(@ModelAttribute Pedido pedido) {
        if (pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            Cliente cliente = clienteRepository.findById(pedido.getCliente().getId()).orElse(null);
            if (cliente != null) {
                pedido.setCliente(cliente);
                pedidoRepository.save(pedido);
                System.out.println("✅ Pedido guardado correctamente.");
            } else {
                System.out.println("⚠️ Cliente con ID " + pedido.getCliente().getId() + " no encontrado.");
            }
        } else {
            System.out.println("⚠️ No se asignó un cliente válido al pedido.");
        }
        return "redirect:/pedidos";
    }
}



