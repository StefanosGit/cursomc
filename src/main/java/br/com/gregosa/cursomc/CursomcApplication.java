package br.com.gregosa.cursomc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gregosa.cursomc.domain.Categoria;
import br.com.gregosa.cursomc.domain.Cidade;
import br.com.gregosa.cursomc.domain.Cliente;
import br.com.gregosa.cursomc.domain.Endereco;
import br.com.gregosa.cursomc.domain.Estado;
import br.com.gregosa.cursomc.domain.Produto;
import br.com.gregosa.cursomc.domain.enums.TipoCliente;
import br.com.gregosa.cursomc.repositories.CategoriaRepository;
import br.com.gregosa.cursomc.repositories.CidadeRepository;
import br.com.gregosa.cursomc.repositories.ClienteRepository;
import br.com.gregosa.cursomc.repositories.EnderecoRepository;
import br.com.gregosa.cursomc.repositories.EstadoRepository;
import br.com.gregosa.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired EnderecoRepository enderecoRepository;


	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador",new BigDecimal(2000.00));
		Produto p2 = new Produto(null, "Impressora",new BigDecimal(800.00));
		Produto p3 = new Produto(null, "Mouse",new BigDecimal(80.00));
		
		
		List<Categoria> categorias = new ArrayList<>();
		
		categorias.add(cat1);
		categorias.add(cat2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(categorias);
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
				Cliente cli1 = new Cliente(null, "Maria Silva", "maria@email.com", "1234123423", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("2233-4455", "92233-4455"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "123B", "fundos", "Meier", "22777-000", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Lima", "200", "", "Jabaquara", "51000=001", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2)); 
		
		clienteRepository.save(cli1);
		
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}
}
