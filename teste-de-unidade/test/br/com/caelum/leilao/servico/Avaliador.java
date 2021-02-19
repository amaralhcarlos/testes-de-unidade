package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;

	private List<Lance> maiores;

	public void avalia(Leilao leilao) {

		leilao.getLances().forEach(lance -> {
			if (lance.getValor() > maiorLance) {
				maiorLance = lance.getValor();
			}

			if (lance.getValor() < menorLance) {
				menorLance = lance.getValor();
			}
		});

		encontraTresMaiores(leilao);

	}

	private void encontraTresMaiores(Leilao leilao) {

		maiores = new ArrayList<Lance>(leilao.getLances());

		Collections.sort(maiores);

		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());

	}

	public double getMaiorLance() {
		return maiorLance;
	}

	public double getMenorLance() {
		return menorLance;
	}

	public List<Lance> getTresMaiores() {
		return maiores;
	}

	public double getMediaLances(Leilao leilao) {

		double somaLances = 0;

		for (Lance lance : leilao.getLances()) {
			somaLances += lance.getValor();
		}

		return somaLances / leilao.getLances().size();

	}

}
