package br.com.caelum.matematica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void deveChecarContaMalucaComValorMaiorQueTrinta() {

		MatematicaMaluca matematica = new MatematicaMaluca();

		assertEquals(124, matematica.contaMaluca(31), 0.00001);
		assertEquals(128, matematica.contaMaluca(32), 0.00001);
	}

	@Test
	public void deveChecarContaMalucaComValorMaiorQueDezEMenorOuIgualTrinta() {

		MatematicaMaluca matematica = new MatematicaMaluca();

		assertEquals(33, matematica.contaMaluca(11), 0.00001);
		assertEquals(90, matematica.contaMaluca(30), 0.00001);
	}

	@Test
	public void deveChecarContaMalucaComValorMenorOuIgualDez() {

		MatematicaMaluca matematica = new MatematicaMaluca();

		assertEquals(20, matematica.contaMaluca(10), 0.00001);
		assertEquals(10, matematica.contaMaluca(5), 0.00001);
	}

}
