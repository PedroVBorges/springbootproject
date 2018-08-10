package com.example.restxbrain.controller;

import com.example.restxbrain.exception.ResourceNotFoundException;
import com.example.restxbrain.model.Pedido;
import com.example.restxbrain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoController {

	@Autowired
	PedidoRepository PedidoRepository;
	
	/* Obter todos os pedidos */
	@GetMapping("/pedidos")
	public List<Pedido> getAllPedidos() {
	    return PedidoRepository.findAll();
	}	
	
	/* Criar um pedido */
	@PostMapping("/pedidos")
	public Pedido createPedido(@RequestBody Pedido pedido) {
	    return PedidoRepository.save(pedido);
	}
	
	/* obter somente um pedido */
	@GetMapping("/pedidos/{id}")
	public Pedido getPedidoById(@PathVariable(value = "id") Integer pedidoId) {
	    return PedidoRepository.findById(pedidoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Pedido", "id", pedidoId));
	}
}
