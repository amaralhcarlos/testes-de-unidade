package br.com.caelum.leilao.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

		leilao.propoe(new Lance(joao, 80.0));
		leilao.propoe(new Lance(maria, 40.0));
		leilao.propoe(new Lance(jose, 130.0));

		double maiorEsperado = 130.0;
		double menorEsperado = 40.0;
		double mediaEsperada = 83.33333;

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);

		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

		assertEquals(mediaEsperada, leiloeiro.getMediaLances(leilao), 0.00001);
	}

}
