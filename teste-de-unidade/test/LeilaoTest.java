import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {

		Leilao leilao = new Leilao("Macbook Pro 15'");

		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 4500.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(4500.0, leilao.getLances().get(0).getValor(), 0.0001);
		assertEquals("Steve Jobs", leilao.getLances().get(0).getUsuario().getNome());

	}

	@Test
	public void deveDobrarUmLance() {

		Leilao leilao = new Leilao("Macbook Pro 15'");

		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario steveWozniak = new Usuario("Steve Wozniak");

		leilao.propoe(new Lance(steveJobs, 4500.0));
		leilao.propoe(new Lance(steveWozniak, 5000.0));

		leilao.dobraLance(steveJobs);

		assertEquals(3, leilao.getLances().size());
		assertEquals(9000.0, leilao.getLances().get(2).getValor(), 0.0001);

	}

	@Test
	public void deveIgnorarDobrarQuandoOLanceNaoExiste() {

		Leilao leilao = new Leilao("Macbook Pro 15'");

		Usuario steveJobs = new Usuario("Steve Jobs");
		leilao.propoe(new Lance(steveJobs, 4500.0));

		Usuario steveWozniak = new Usuario("Steve Wozniak");
		leilao.dobraLance(steveWozniak);

		assertEquals(1, leilao.getLances().size());
		assertEquals(4500.0, leilao.getLances().get(0).getValor(), 0.0001);

	}

	@Test
	public void deveReceberVariosLances() {

		Leilao leilao = new Leilao("Macbook Pro 15'");

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 4500.0));
		leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 5500.0));

		assertEquals(2, leilao.getLances().size());
		assertEquals(4500.0, leilao.getLances().get(0).getValor(), 0.0001);
		assertEquals(5500.0, leilao.getLances().get(1).getValor(), 0.0001);

	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {

		Leilao leilao = new Leilao("Macbook Pro 15'");

		Usuario steveJobs = new Usuario("Steve Jobs");

		leilao.propoe(new Lance(steveJobs, 4500.0));
		leilao.propoe(new Lance(steveJobs, 7500.0));

		assertEquals(1, leilao.getLances().size());
		assertEquals(4500.0, leilao.getLances().get(0).getValor(), 0.0001);

	}

	@Test
	public void naoDeveAceitarMaisDoQueCincoLancesDoMesmoUsuario() {

		Leilao leilao = new Leilao("Macbook Pro 15'");

		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		leilao.propoe(new Lance(steveJobs, 2500.0));
		leilao.propoe(new Lance(billGates, 3500.0));

		leilao.propoe(new Lance(steveJobs, 4500.0));
		leilao.propoe(new Lance(billGates, 5500.0));

		leilao.propoe(new Lance(steveJobs, 6500.0));
		leilao.propoe(new Lance(billGates, 7500.0));

		leilao.propoe(new Lance(steveJobs, 8500.0));
		leilao.propoe(new Lance(billGates, 9500.0));

		leilao.propoe(new Lance(steveJobs, 10500.0));
		leilao.propoe(new Lance(billGates, 11500.0));

		leilao.propoe(new Lance(steveJobs, 12500.0));

		assertEquals(10, leilao.getLances().size());
		assertEquals(11500.0, leilao.ultimoLanceDado().getValor(), 0.0001);

	}

}
