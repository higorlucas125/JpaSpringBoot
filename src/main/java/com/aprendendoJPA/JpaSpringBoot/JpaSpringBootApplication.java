package com.aprendendoJPA.JpaSpringBoot;

import com.aprendendoJPA.JpaSpringBoot.domain.Categoria;
import com.aprendendoJPA.JpaSpringBoot.domain.Produto;
import com.aprendendoJPA.JpaSpringBoot.repositories.CategoriaRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class JpaSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaSpringBootApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");

		Produto produto1 = new Produto(null,"Computador",4000.00);
		Produto produto2 = new Produto(null,"Impressora", 800.00);
		Produto produto3 = new Produto(null,"Mouse da razy", 350.00);

		// Iniciando a lista de categorias dos produtos
		cat1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		cat2.getProdutos().addAll(Collections.singletonList(produto2));

		// Iniciando a lista de produtos de categorias
		produto1.getCategoriaList().addAll(Collections.singletonList(cat1));
		produto2.getCategoriaList().addAll(Arrays.asList(cat1,cat2));
		produto3.getCategoriaList().addAll(Collections.singletonList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
	}
}
