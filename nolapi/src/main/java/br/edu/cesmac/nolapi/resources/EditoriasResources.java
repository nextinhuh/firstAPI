package br.edu.cesmac.nolapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cesmac.nolapi.domain.Editoria;
import br.edu.cesmac.nolapi.repository.EditoriasRepository;

@RestController
public class EditoriasResources {
	
	@Autowired
	private EditoriasRepository editoriasRepository;
	
	
	
	
	@GetMapping(path = "/editorias")
	public List<Editoria> listarTodas() {		
		
		return editoriasRepository.findAll();
	}
}
