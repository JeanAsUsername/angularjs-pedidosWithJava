package com.nicola.mixedapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicola.mixedapp.dtos.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	public Pedido findByTitle(String title);

}
