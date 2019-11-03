package com.aprendendoJPA.JpaSpringBoot.services;

import com.aprendendoJPA.JpaSpringBoot.domain.Categoria;
import org.springframework.stereotype.Service;

@Service
public interface CategoriaService {

    Categoria buscar ( Integer id);
}
