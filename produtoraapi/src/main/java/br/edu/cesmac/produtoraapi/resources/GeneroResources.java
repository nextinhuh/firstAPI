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


import br.edu.cesmac.produtoraapi.domain.Genero;
import br.edu.cesmac.produtoraapi.repository.GeneroRepository;

@RestController
@RequestMapping("/generos")
public class GeneroResources {

	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping
	public List<Genero> listartodos() {
		return generoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Genero genero) {
		generoRepository.save(genero);
		
	   URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") .buildAndExpand(genero.getIdGenero()).toUri();
	   
	   return ResponseEntity.created(uri).build();
	   
	}

	@PutMapping
	public void alterar(@RequestBody Genero genero) {
		
		generoRepository.save(genero);
	
	}

	@DeleteMapping
	public void deletar(@RequestBody Genero genero) {
		generoRepository.delete(genero);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Genero> buscarPorId(@PathVariable("id") Long idGenero) {
		return generoRepository.findById(idGenero).map(genero -> ResponseEntity.ok(genero)).orElse(ResponseEntity.notFound().build());
	}
}
