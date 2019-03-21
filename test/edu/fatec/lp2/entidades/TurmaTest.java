package edu.fatec.lp2.entidades;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TurmaTest {
	private Turma cut;
	
	@Before
	public void init() {
		cut = new Turma(1);
	}
	
	@Test
	public void validaInclusaoAluno() {
		Aluno aluno = new Aluno(1, "pepe", "curso 1", 50.5f);
		String output = "1 - pepe\n";
		assertTrue(cut.incluir(aluno));
		assertEquals(1, cut.size());
		Aluno consultado = cut.consultarAlunoPorNome("pepe");
		assertEquals(50.5f, consultado.getMedia(), 0.1f);
		assertEquals(aluno, consultado);
		assertEquals(aluno, consultado);
		assertEquals(aluno, consultado);
		assertEquals(output, cut.toString());
	}
	
	@Test
	public void validaInclusaoDoisAluno() {
		cut = new Turma(2);
		Aluno aluno1 = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		Aluno aluno2 = new Aluno(2, "aluno 2", "curso 2", 55.5f);
		String output = "1 - aluno 1\n2 - aluno 2\n";
		assertTrue(cut.incluir(aluno1));
		assertTrue(cut.incluir(aluno2));
		assertEquals(2, cut.size());
		assertEquals(output, cut.toString());
	}
	
	@Test
	public void validaInclusaoAlunoBufferCheio() {
		Aluno aluno1 = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		Aluno aluno2 = new Aluno(2, "aluno 2", "curso 2", 60.5f);
		assertTrue(cut.incluir(aluno1));
		assertFalse(cut.incluir(aluno2));
		assertEquals(1, cut.size());
		assertNull(cut.consultarAlunoPorNome("aluno 2"));
		assertNull(cut.consultarAlunoPorCurso("curso 2"));
		assertNull(cut.consultarAlunoPorMatricula(2));
	}
	
	@Test
	public void validaAlteracaoAlunoExistente() {
		Aluno aluno1 = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		Aluno aluno2 = new Aluno(2, "aluno 2", "curso 2", 60.5f);
		assertTrue(cut.incluir(aluno1));
		assertEquals(1, cut.size());
		assertTrue(cut.alterar("aluno 1", aluno2));
		assertEquals(aluno2, cut.consultarAlunoPorNome("aluno 2"));
		assertEquals(aluno2, cut.consultarAlunoPorMatricula(2));
		assertNull(cut.consultarAlunoPorNome("aluno 1"));
		assertNull(cut.consultarAlunoPorCurso("curso 1"));
		assertNull(cut.consultarAlunoPorMatricula(1));
	}
	
	@Test
	public void validaAlteracaoAlunoInexistente() {
		Aluno aluno1 = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		Aluno aluno2 = new Aluno(2, "aluno 2", "curso 2", 60.5f);
		assertTrue(cut.incluir(aluno1));
		assertEquals(1, cut.size());
		assertFalse(cut.alterar("aluno 3", aluno2));
		assertEquals(aluno1, cut.consultarAlunoPorNome("aluno 1"));
		assertEquals(aluno1, cut.consultarAlunoPorCurso("curso 1"));
		assertEquals(aluno1, cut.consultarAlunoPorMatricula(1));
		assertNull(cut.consultarAlunoPorNome("aluno 2"));
		assertNull(cut.consultarAlunoPorCurso("curso 2"));
		assertNull(cut.consultarAlunoPorMatricula(2));
	}
	
	@Test
	public void validaAlteracaoAlunoPorReferenciaNula() {
		Aluno aluno1 = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		Aluno aluno2 = null;
		assertTrue(cut.incluir(aluno1));
		assertEquals(1, cut.size());
		assertFalse(cut.alterar("aluno 1", aluno2));
		assertEquals(aluno1, cut.consultarAlunoPorNome("aluno 1"));
		assertEquals(aluno1, cut.consultarAlunoPorCurso("curso 1"));
		assertEquals(aluno1, cut.consultarAlunoPorMatricula(1));
		assertNull(cut.consultarAlunoPorNome("aluno 2"));
		assertNull(cut.consultarAlunoPorCurso("curso 2"));
		assertNull(cut.consultarAlunoPorMatricula(2));
	}
	
	@Test
	public void validaInclusaoAlunoNulo() {
		Aluno aluno1 = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		Aluno aluno2 = null;
		assertTrue(cut.incluir(aluno1));
		assertFalse(cut.incluir(aluno2));
		assertEquals(1, cut.size());
		assertNull(cut.consultarAlunoPorNome("aluno 2"));
		assertNull(cut.consultarAlunoPorCurso("curso 2"));
		assertNull(cut.consultarAlunoPorMatricula(2));
	}
	
	@Test
	public void validaRemocaoAluno() {
		Aluno aluno = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		cut.incluir(aluno);
		assertTrue(cut.excluir("aluno 1"));
		assertEquals(0, cut.size());
		assertNull(cut.consultarAlunoPorNome("aluno 1"));
		assertNull(cut.consultarAlunoPorCurso("curso 1"));
		assertNull(cut.consultarAlunoPorMatricula(1));
	}
	
	@Test
	public void validaRemocaoAlunoInexistente() {
		Aluno aluno = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		cut.incluir(aluno);
		assertFalse(cut.excluir("aluno 3"));
		assertEquals(1, cut.size());
		assertNotNull(cut.consultarAlunoPorNome("aluno 1"));
		assertNotNull(cut.consultarAlunoPorCurso("curso 1"));
		assertNotNull(cut.consultarAlunoPorMatricula(1));
	}
	
	@Test
	public void validaRemocaoAlunoBufferVazio() {
		cut = new Turma(2);
		Aluno aluno1 = new Aluno(1, "aluno 1", "curso 1", 55.5f);
		Aluno aluno2 = new Aluno(2, "aluno 2", "curso 2", 60.5f);
		cut.incluir(aluno1);
		cut.incluir(aluno2);
		assertEquals(2, cut.size());
		assertTrue(cut.excluir("aluno 1"));
		assertTrue(cut.excluir("aluno 2"));
		assertEquals(0, cut.size());
		assertNull(cut.consultarAlunoPorNome("aluno 1"));
		assertNull(cut.consultarAlunoPorCurso("curso 1"));
		assertNull(cut.consultarAlunoPorMatricula(1));
		assertFalse(cut.excluir("aluno2"));
	}
}
