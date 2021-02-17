package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;

	public void avalia(Leilao leilao) {

		leilao.getLances().forEach(lance -> {
			if (lance.getValor() > maiorLance) {
				maiorLance = lance.getValor();
			}

			if (lance.getValor() < menorLance) {
				menorLance = lance.getValor();
			}
		});

	}

	public double getMaiorLance() {
		return maiorLance;
	}

	public double getMenorLance() {
		return menorLance;
	}

	public double getMediaLances(Leilao leilao) {

		double somaLances = 0;

		for (Lance lance : leilao.getLances()) {
			somaLances += lance.getValor();
		}

		return somaLances / leilao.getLances().size();

	}

}
