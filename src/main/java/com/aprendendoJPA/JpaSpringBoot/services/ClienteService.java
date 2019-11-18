package com.aprendendoJPA.JpaSpringBoot.services;

import com.aprendendoJPA.JpaSpringBoot.domain.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    Cliente findId (Integer id);
}
