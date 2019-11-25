package com.aprendendoJPA.JpaSpringBoot.repositories;

import com.aprendendoJPA.JpaSpringBoot.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
