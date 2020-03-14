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

import br.edu.cesmac.produtoraapi.domain.Ator;

import br.edu.cesmac.produtoraapi.repository.AtorRepository;

@RestController
@RequestMapping("/atores")
public class AtorResources {

	
	@Autowired
	private AtorRepository atorRepository;
	
	@GetMapping
	public List<Ator> listartodos() {
		return atorRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Ator ator) {
		atorRepository.save(ator);
		
	   URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") .buildAndExpand(ator.getIdAtor()).toUri();
	   
	   return ResponseEntity.created(uri).build();
	   
	}

	@PutMapping
	public void alterar(@RequestBody Ator ator) {
		
		atorRepository.save(ator);
	
	}

	@DeleteMapping
	public void deletar(@RequestBody Ator ator) {
		atorRepository.delete(ator);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ator> buscarPorId(@PathVariable("id") Long idAtor) {
		return atorRepository.findById(idAtor).map(ator -> ResponseEntity.ok(ator)).orElse(ResponseEntity.notFound().build());
	}
 
	
}
