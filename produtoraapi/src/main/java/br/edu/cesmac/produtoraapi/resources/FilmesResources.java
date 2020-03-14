package br.edu.cesmac.produtoraapi.resources;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.cesmac.produtoraapi.domain.Filme;
import br.edu.cesmac.produtoraapi.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmesResources {

	@Autowired
	private FilmeRepository filmeRepository;
					
	@GetMapping
	public List<Filme> listartodos() {
		return filmeRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Filme filme) {
		filmeRepository.save(filme);
		
	   URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") .buildAndExpand(filme.getIdFilme()).toUri();
	   
	   return ResponseEntity.created(uri).build();
	   
	}

	@PutMapping
	public void alterar(@RequestBody Filme filme) {
		
		filmeRepository.save(filme);
	
	}

	@DeleteMapping
	public void deletar(@RequestBody Filme filme) {
		filmeRepository.delete(filme);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Filme> buscarPorId(@PathVariable("id") Long idFilme) {
		return filmeRepository.findById(idFilme).map(filme -> ResponseEntity.ok(filme)).orElse(ResponseEntity.notFound().build());
	}

}
