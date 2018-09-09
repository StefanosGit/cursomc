package br.com.gregosa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregosa.cursomc.domain.Cliente;
import br.com.gregosa.cursomc.domain.Pedido;
import br.com.gregosa.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = repo.findById(id);
		return pedido.orElseThrow(() -> new br.com.gregosa.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
