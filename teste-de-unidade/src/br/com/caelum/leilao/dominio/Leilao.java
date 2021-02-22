package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {

		if (lances.isEmpty() || podeDarLance(lance)) {
			lances.add(lance);
		}

	}

	public void dobraLance(Usuario usuario) {

		List<Lance> lancesDoUsuario = filtraLancesDoUsuario(usuario);

		if (!lancesDoUsuario.isEmpty()) {

			int ultimoLance = lancesDoUsuario.size() - 1;
			Lance ultimo = lancesDoUsuario.get(ultimoLance);

			propoe(new Lance(usuario, ultimo.getValor() * 2));
		}

		lancesDoUsuario = filtraLancesDoUsuario(usuario);

	}

	private boolean podeDarLance(Lance lance) {

		List lancesDoUsuario = filtraLancesDoUsuario(lance.getUsuario());
		return !ultimoLanceDado().getUsuario().equals(lance.getUsuario()) && (lancesDoUsuario.size() < 5);

	}

	private List<Lance> filtraLancesDoUsuario(Usuario usuario) {

		return lances.stream().filter(l -> l.getUsuario().equals(usuario)).collect(Collectors.toList());

	}

	public Lance ultimoLanceDado() {

		int ultimoLance = lances.size() - 1;
		return lances.get(ultimoLance);

	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
