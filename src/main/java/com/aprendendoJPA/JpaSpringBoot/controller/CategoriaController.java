package com.aprendendoJPA.JpaSpringBoot.controller;

import com.aprendendoJPA.JpaSpringBoot.domain.Categoria;
import com.aprendendoJPA.JpaSpringBoot.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id){
        Categoria obj = categoriaService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
