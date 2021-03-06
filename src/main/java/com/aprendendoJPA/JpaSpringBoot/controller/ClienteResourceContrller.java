package com.aprendendoJPA.JpaSpringBoot.controller;

import com.aprendendoJPA.JpaSpringBoot.domain.Cliente;
import com.aprendendoJPA.JpaSpringBoot.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResourceContrller {
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id){
        Cliente obj = clienteService.findId(id);
        return ResponseEntity.ok().body(obj);
    }

}
