package edu.fatec.lp2.entidades;

public class Turma {
	private Aluno[] alunos;
	private int indice;
	
	public Turma(int capacidade) {
		alunos = new Aluno[capacidade];
		indice = 0;
	}
	
	private int getArraySize() {
		return alunos.length;
	}
	
	public int size() {
		return indice;
	}
	
	public boolean incluir(Aluno aluno) {
		if (aluno != null && indice < getArraySize()) {
			alunos[indice++] = aluno;
			return true;
		} else
			return false;
	}
	
	public Aluno consultarAlunoPorNome(String nome) {
		for (int i = 0; i < indice; i++) {
			Aluno aluno = alunos[i];
			if (aluno.getNome().equals(nome))
				return aluno;
		}
		return null;
	}
	
	public Aluno consultarAlunoPorMatricula(int matricula) {
		for (int i = 0; i < indice; i++) {
			Aluno aluno = alunos[i];
			if (aluno.getMatricula() == matricula)
				return aluno;
		}
		return null;
	}
	
	public Aluno consultarAlunoPorCurso(String curso) {
		for (int i = 0; i < indice; i++) {
			Aluno aluno = alunos[i];
			if (aluno.getCurso().equals(curso))
				return aluno;
		}
		return null;
	}
	
	public boolean alterar(String nome, Aluno alunoAlterado) {
		for (int i = 0; i < indice; i++) {
			Aluno aluno = alunos[i];
			if (alunoAlterado != null && aluno.getNome().equals(nome)) {
				alunos[i] = alunoAlterado;
				return true;
			}
		}
		return false;
	}
	
	public boolean excluir(String nome) {
		for (int i = 0; i < indice; i++) {
			Aluno aluno = alunos[i];
			if (aluno.getNome().equals(nome)) {
				alunos[i] = null;
				for (int j = i+1; j < indice; j++) {
					alunos[j-1] = alunos[j];
				}
				alunos[--indice] = null;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < indice; i++) {
			sb.append(alunos[i].toString()).append("\n");
		}
		return sb.toString();
	}
	
	
}
