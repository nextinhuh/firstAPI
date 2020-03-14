package br.edu.cesmac.produtoraapi.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Filme {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilme;	
	private String titulo;	
	private Date data_lancamento;	
	private String sinopse;
	
	@ManyToOne
	private Genero genero;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}	
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Long getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}
	
	
	
}
