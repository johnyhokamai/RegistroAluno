package edu.fatec.lp2.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class Aluno {

	private int matricula;
	private String nome;
	private String curso;
	private float media;
	
	
	
	
	

	public Aluno(int matricula, String nome, String curso, float media) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.media = media;
	}



	@Override
	public String toString() {
		return String.valueOf(getMatricula()) + " - " + getNome();
	}
	
	

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	
	
}
