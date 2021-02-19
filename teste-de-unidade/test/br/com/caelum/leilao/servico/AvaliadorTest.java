package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// TODO Auto-generated method stub

		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Bola da Copa de 2018");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(jose, 300.0));

		double maiorEsperado = 300.0;
		double menorEsperado = 100.0;
		double mediaEsperada = 200.0;

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(mediaEsperada, leiloeiro.getMediaLances(leilao), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		// TODO Auto-generated method stub

		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Bola da Copa de 2018");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(jose, 100.0));

		double maiorEsperado = 300.0;
		double menorEsperado = 100.0;
		double mediaEsperada = 200.0;

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(mediaEsperada, leiloeiro.getMediaLances(leilao), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		// TODO Auto-generated method stub

		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Bola da Copa de 2018");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(jose, 200.0));

		double maiorEsperado = 300.0;
		double menorEsperado = 100.0;
		double mediaEsperada = 200.0;

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(mediaEsperada, leiloeiro.getMediaLances(leilao), 0.00001);
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		// TODO Auto-generated method stub

		Usuario joao = new Usuario("João");

		Leilao leilao = new Leilao("Bola da Copa de 2018");

		leilao.propoe(new Lance(joao, 100.0));

		double maiorEsperado = 100.0;
		double menorEsperado = 100.0;
		double mediaEsperada = 100.0;

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(mediaEsperada, leiloeiro.getMediaLances(leilao), 0.00001);
	}

	@Test
	public void deveEntenderLeilaoSemLances() {

		Leilao leilao = new Leilao("Bola da Copa de 2018");

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(0, leiloeiro.getTresMaiores().size());

	}

	@Test
	public void deveEntenderLeilaoComDoisLances() {

		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");

		Leilao leilao = new Leilao("Bola da Copa de 2018");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(jose, 300.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(2, leiloeiro.getTresMaiores().size());

	}

	@Test
	public void deveEntenderLeilaoComCincoLances() {

		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");
		Usuario pedro = new Usuario("Pedro");
		Usuario marco = new Usuario("Marco");
		Usuario antonio = new Usuario("Antônio");

		Leilao leilao = new Leilao("Bola da Copa de 2018");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(pedro, 150.0));
		leilao.propoe(new Lance(marco, 400.0));
		leilao.propoe(new Lance(antonio, 900.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(900.0, leiloeiro.getTresMaiores().get(0).getValor(), 0.00001);
		assertEquals(400.0, leiloeiro.getTresMaiores().get(1).getValor(), 0.00001);
		assertEquals(300.0, leiloeiro.getTresMaiores().get(2).getValor(), 0.00001);
		assertEquals(3, leiloeiro.getTresMaiores().size());

	}

}
