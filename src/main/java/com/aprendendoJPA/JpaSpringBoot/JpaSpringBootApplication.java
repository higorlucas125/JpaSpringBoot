package com.aprendendoJPA.JpaSpringBoot;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aprendendoJPA.JpaSpringBoot.domain.Categoria;
import com.aprendendoJPA.JpaSpringBoot.domain.Cidade;
import com.aprendendoJPA.JpaSpringBoot.domain.Cliente;
import com.aprendendoJPA.JpaSpringBoot.domain.Endereco;
import com.aprendendoJPA.JpaSpringBoot.domain.Estado;
import com.aprendendoJPA.JpaSpringBoot.domain.Pagamento;
import com.aprendendoJPA.JpaSpringBoot.domain.PagamentoComBoleto;
import com.aprendendoJPA.JpaSpringBoot.domain.PagamentoComCartao;
import com.aprendendoJPA.JpaSpringBoot.domain.Pedido;
import com.aprendendoJPA.JpaSpringBoot.domain.Produto;
import com.aprendendoJPA.JpaSpringBoot.domain.enums.EstadoPagamento;
import com.aprendendoJPA.JpaSpringBoot.domain.enums.TipoCliente;
import com.aprendendoJPA.JpaSpringBoot.repositories.CategoriaRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.CidadeRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.ClienteRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.EnderecoRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.EstadoRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.PagamentoRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.PedidoRepository;
import com.aprendendoJPA.JpaSpringBoot.repositories.ProdutoRepository;


@SpringBootApplication
public class JpaSpringBootApplication implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger( JpaSpringBootApplication.class );

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;


    public static void main( String[] args ) {

        SpringApplication.run( JpaSpringBootApplication.class, args );

    }


    @Override
    public void run( String... args )
        throws Exception {

        Categoria cat1 = new Categoria( null, "Informatica" );
        Categoria cat2 = new Categoria( null, "Escritorio" );

        Produto produto1 = new Produto( null, "Computador", 4000.00 );
        Produto produto2 = new Produto( null, "Impressora", 800.00 );
        Produto produto3 = new Produto( null, "Mouse da razy", 350.00 );

        Categoria cat3 = null;

        // Iniciando a lista de categorias dos produtos
        cat1.getProdutos().addAll( Arrays.asList( produto1, produto2, produto3 ) );
        cat2.getProdutos().addAll( Collections.singletonList( produto2 ) );

        // Iniciando a lista de produtos de categorias
        produto1.getCategoriaList().addAll( Collections.singletonList( cat1 ) );
        produto2.getCategoriaList().addAll( Arrays.asList( cat1, cat2 ) );
        produto3.getCategoriaList().addAll( Collections.singletonList( cat1 ) );
        // logger.info("Salvando a categoria");
        // try {
        // throw new NullPointerException("é o cat3 está nullo ");
        // }catch (Exception e){
        // logger.error("Aconteceu algum erro ", e);
        // }

        categoriaRepository.saveAll( Arrays.asList( cat1, cat2 ) );
        logger.info( "Salvando produtos " );
        produtoRepository.saveAll( Arrays.asList( produto1, produto2, produto3 ) );
        logger.info( " Salvo categoria e produtos" );

        // CRIANDO O JOIN DE UM PARA MUITOS DA CIDADES PARA O ESTADO

        Estado minasGerais = new Estado( "MINAS GERAIS" );
        Estado eSaoPaulo = new Estado( "SÃO PAULO" );
        Estado santaCatarina = new Estado( "SANTA CATARINA" );

        Cidade uberlandia = new Cidade( "UBERLÂNDIA", minasGerais );
        Cidade uberaba = new Cidade( "UBERABA", minasGerais );
        Cidade saoPaulo = new Cidade( "SÃO PAULO", eSaoPaulo );
        Cidade florianopolis = new Cidade( "FLORIANOPOLIS", santaCatarina );

        minasGerais.getCidades().addAll( Arrays.asList( uberaba, uberlandia ) );
        eSaoPaulo.getCidades().addAll( Collections.singletonList( saoPaulo ) );
        santaCatarina.getCidades().addAll( Collections.singletonList( florianopolis ) );

        estadoRepository.saveAll( Arrays.asList( minasGerais, eSaoPaulo, santaCatarina ) );
        logger.info( "Salvou estados" );

        cidadeRepository.saveAll( Arrays.asList( uberaba, uberlandia, saoPaulo, florianopolis ) );
        logger.info( "Salvou cidades e estados" );

        // CRIANDO O CLIENTE E O ENDEREÇO

        Cliente cliente1 = new Cliente( "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA );
        Cliente cliente2 =
            new Cliente( "Mariane Lívia Tatiane Caldeira", "marianeliviatatianecaldeira_@edu.uniso.br", "52206155303", TipoCliente.PESSOAFISICA );

        Endereco e = new Endereco( "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cliente1, uberlandia );
        Endereco e2 = new Endereco( "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente2, saoPaulo );

        cliente1.getEnderecos().addAll( Collections.singletonList( e ) );
        cliente2.getEnderecos().addAll( Collections.singletonList( e2 ) );

        clienteRepository.saveAll( Arrays.asList( cliente1, cliente2 ) );
        enderecoRepository.saveAll( Arrays.asList( e, e2 ) );

        // CRIANDO PEDIDOS E PAGAMENTO
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
        Pedido ped1 = new Pedido( null, sdf.parse( "30/09/2019 16:00" ), cliente1, e );
        Pedido ped2 = new Pedido( null, sdf.parse( "30/08/2019 15:00" ), cliente1, e2 );

        Pagamento pagamento = new PagamentoComCartao( null, EstadoPagamento.QUITADO, ped1, 6 );
        ped1.setPagamento( pagamento );

        Pagamento pagamento1 = new PagamentoComBoleto( null, EstadoPagamento.PENDENTE, ped2, sdf.parse( "20/10/2019 00:00" ), null );
        ped2.setPagamento( pagamento1 );

        cliente1.getPedidos().addAll( Arrays.asList( ped1, ped2 ) );

        pedidoRepository.saveAll( Arrays.asList( ped1, ped2 ) );
//        pagamentoRepository.saveAll( Arrays.asList( pagamento1 ) );
        pagamentoRepository.saveAll( Arrays.asList( pagamento, pagamento1 ) );
        logger.info( "Terminou de criar tudo" );
    }
}
