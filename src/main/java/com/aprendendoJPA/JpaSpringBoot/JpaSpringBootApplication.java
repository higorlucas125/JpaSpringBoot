package com.aprendendoJPA.JpaSpringBoot;

import com.aprendendoJPA.JpaSpringBoot.domain.Categoria;
import com.aprendendoJPA.JpaSpringBoot.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JpaSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaSpringBootApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Escritorio");

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}
