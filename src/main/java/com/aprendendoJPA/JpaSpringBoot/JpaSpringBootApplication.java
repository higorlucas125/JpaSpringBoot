package com.aprendendoJPA.JpaSpringBoot;

import com.aprendendoJPA.JpaSpringBoot.domain.Categoria;
import com.aprendendoJPA.JpaSpringBoot.domain.Cidade;
import com.aprendendoJPA.JpaSpringBoot.domain.Estado;
import com.aprendendoJPA.JpaSpringBoot.domain.Produto;
import com.aprendendoJPA.JpaSpringBoot.repositories.CategoriaRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.CidadeRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.EstadoRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.ProdutoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class JpaSpringBootApplication implements CommandLineRunner {
	private static final Logger logger = Logger.getLogger(JpaSpringBootApplication.class);

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

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

		Categoria cat3 = null;

		// Iniciando a lista de categorias dos produtos
		cat1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		cat2.getProdutos().addAll(Collections.singletonList(produto2));

		// Iniciando a lista de produtos de categorias
		produto1.getCategoriaList().addAll(Collections.singletonList(cat1));
		produto2.getCategoriaList().addAll(Arrays.asList(cat1,cat2));
		produto3.getCategoriaList().addAll(Collections.singletonList(cat1));
//		logger.info("Salvando a categoria");
//		try {
//			throw new NullPointerException("é o cat3 está nullo ");
//		}catch (Exception e){
//			logger.error("Aconteceu algum erro ", e);
//		}

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		logger.info("Salvando produtos ");
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
		logger.info(" Salvo categoria e produtos");


		// CRIANDO O JOIN DE UM PARA MUITOS DA CIDADES PARA O ESTADO


		Estado minasGerais = new Estado("MINAS GERAIS");
		Estado eSaoPaulo = new Estado("SÃO PAULO");
		Estado santaCatarina = new Estado("SANTA CATARINA");

		Cidade uberlandia = new Cidade("UBERLÂNDIA",minasGerais);
		Cidade uberaba = new Cidade("UBERABA",minasGerais);
		Cidade saoPaulo = new Cidade("SÃO PAULO",eSaoPaulo);
		Cidade florianopolis = new Cidade("FLORIANOPOLIS",santaCatarina);


		minasGerais.getCidades().addAll(Arrays.asList(uberaba,uberlandia));
		eSaoPaulo.getCidades().addAll(Collections.singletonList(saoPaulo));
		santaCatarina.getCidades().addAll(Collections.singletonList(florianopolis));

		estadoRepository.saveAll(Arrays.asList(minasGerais,eSaoPaulo,santaCatarina));
		logger.info("Salvou estados");

		cidadeRepository.saveAll(Arrays.asList(uberaba,uberlandia,saoPaulo,florianopolis));
		logger.info("Salvou cidades e estados");
	}
}
