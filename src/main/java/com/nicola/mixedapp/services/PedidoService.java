package com.nicola.mixedapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nicola.mixedapp.dtos.Pedido;

@Service
public interface PedidoService {
	
	public List<Pedido> findAll();
	
	public Pedido findById(Long pedidoId);
	
	public Pedido findByTitle(String title);
	
	public void save(Pedido pedido);
	
	public void delete(Pedido pedido);
}
