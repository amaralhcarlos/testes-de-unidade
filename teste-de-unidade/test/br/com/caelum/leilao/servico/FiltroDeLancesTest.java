package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class FiltroDeLancesTest {

	@Test
	public void deveSelecionarLancesEntre1000E3000() {
		Usuario joao = new Usuario("Joao");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 2000), new Lance(joao, 1000),
				new Lance(joao, 3000), new Lance(joao, 800)));

		assertEquals(1, resultado.size());
		assertEquals(2000, resultado.get(0).getValor(), 0.00001);
	}

	@Test
	public void deveSelecionarLancesEntre500E700() {
		Usuario joao = new Usuario("Joao");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(
				Arrays.asList(new Lance(joao, 600), new Lance(joao, 500), new Lance(joao, 700), new Lance(joao, 800)));

		assertEquals(1, resultado.size());
		assertEquals(600, resultado.get(0).getValor(), 0.00001);
	}

	@Test
	public void deveSelecionarLancesAcimaDe5000() {

		Usuario joao = new Usuario("Joao");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 6000), new Lance(joao, 500),
				new Lance(joao, 7000), new Lance(joao, 800)));

		assertEquals(2, resultado.size());
		assertEquals(6000, resultado.get(0).getValor(), 0.00001);

	}

	@Test
	public void deveRemoverLancesAbaixoDe500() {

		Usuario joao = new Usuario("Joao");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(
				Arrays.asList(new Lance(joao, 100), new Lance(joao, 500), new Lance(joao, 300), new Lance(joao, 400)));

		assertEquals(0, resultado.size());

	}

	@Test
	public void deveRemoverLancesEntre700E1000() {

		Usuario joao = new Usuario("Joao");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(
				Arrays.asList(new Lance(joao, 700), new Lance(joao, 900), new Lance(joao, 800), new Lance(joao, 1000)));

		assertEquals(0, resultado.size());

	}

	@Test
	public void deveRemoverLancesEntre3000E5000() {

		Usuario joao = new Usuario("Joao");

		FiltroDeLances filtro = new FiltroDeLances();
		List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 4500), new Lance(joao, 4000),
				new Lance(joao, 3000), new Lance(joao, 5000)));

		assertEquals(0, resultado.size());

	}
}