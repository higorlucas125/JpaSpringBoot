package com.aprendendoJPA.JpaSpringBoot.repositories;

import com.aprendendoJPA.JpaSpringBoot.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
