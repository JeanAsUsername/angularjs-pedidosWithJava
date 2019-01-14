package com.nicola.mixedapp.Impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nicola.mixedapp.dtos.Pedido;
import com.nicola.mixedapp.repositories.PedidoRepository;
import com.nicola.mixedapp.services.PedidoService;

@Component
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long pedidoId) {
		return pedidoRepository.getOne(pedidoId);
	}
	
	public Pedido findByTitle(String title) {
		return pedidoRepository.findByTitle(title);
	}
	
	public void save(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void delete(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}

}
