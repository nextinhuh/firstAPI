package br.edu.cesmac.produtoraapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.cesmac.produtoraapi.domain.Filme;



@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
}
