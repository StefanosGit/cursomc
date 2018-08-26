package br.com.gregosa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregosa.cursomc.domain.Categoria;
import br.com.gregosa.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElse(null);
		
	}

}
