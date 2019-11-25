package com.aprendendoJPA.JpaSpringBoot.repositories;

import com.aprendendoJPA.JpaSpringBoot.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
