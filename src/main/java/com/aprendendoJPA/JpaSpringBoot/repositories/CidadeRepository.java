package com.aprendendoJPA.JpaSpringBoot.repositories;

import com.aprendendoJPA.JpaSpringBoot.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {
}
