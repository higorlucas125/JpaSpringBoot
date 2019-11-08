package com.aprendendoJPA.JpaSpringBoot.repositories;

import com.aprendendoJPA.JpaSpringBoot.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
