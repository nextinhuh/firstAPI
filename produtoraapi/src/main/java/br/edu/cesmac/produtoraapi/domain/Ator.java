package br.edu.cesmac.produtoraapi.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAtor;
	
	private String nome;
	private Date dt_nasc;
	private String sexo;
	private String biografia;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public Long getIdAtor() {
		return idAtor;
	}
	public void setIdAtor(Long idAtor) {
		this.idAtor = idAtor;
	}
	
	
}
