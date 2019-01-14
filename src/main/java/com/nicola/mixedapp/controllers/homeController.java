package com.nicola.mixedapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nicola.mixedapp.dtos.Pedido;
import com.nicola.mixedapp.services.PedidoService;

@RestController
@RequestMapping("/rest")
public class homeController {
	
	@Autowired
	public PedidoService pedidoService;
	
	@RequestMapping(value="/pedidos", method=RequestMethod.GET)
	public List<Pedido> findAllPedidos() {
		return pedidoService.findAll();
	}
	
	@RequestMapping(value="/pedidos/{id}", method=RequestMethod.GET)
	public Pedido findPedidoById(@PathVariable("id") Long pedidoId) {
		
		return pedidoService.findById(pedidoId);
	}
	
	@RequestMapping(value="/pedidos", method=RequestMethod.POST)
	public Pedido savePedido(@RequestBody Pedido pedidoFromBodyRequest) throws Exception {
		
		List<Pedido> pedidosFromDatabase = pedidoService.findAll();
		
		for (Pedido pedidoFromDatabase : pedidosFromDatabase) {
			
			if (pedidoFromDatabase.getTitle().equalsIgnoreCase(pedidoFromBodyRequest.getTitle())) {
				throw new Exception("Este titulo ya esta en uso");
			}
			
		}
		
		pedidoService.save(pedidoFromBodyRequest);
		Pedido savedPedido = pedidoService.findByTitle(pedidoFromBodyRequest.getTitle());
		return savedPedido;
	}
	
	@RequestMapping(value="/pedidos/{id}", method=RequestMethod.DELETE)
	public void deletePedido(@PathVariable("id") Long pedidoId) {
		
		Pedido pedido = pedidoService.findById(pedidoId);
		
		pedidoService.delete(pedido);
	}
}
