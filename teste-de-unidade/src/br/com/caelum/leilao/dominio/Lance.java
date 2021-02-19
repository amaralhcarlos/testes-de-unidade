package br.com.caelum.leilao.dominio;

public class Lance implements Comparable<Lance> {

	private Usuario usuario;
	private double valor;

	public Lance(Usuario usuario, double valor) {
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public int compareTo(Lance l) {

		if (this.valor > l.getValor())
			return -1;
		if (this.valor < l.getValor())
			return 1;

		return 0;
	}

	@Override
	public String toString() {
		return "Lance [usuario=" + usuario.getNome() + ", valor=" + valor + "]";
	}

}
