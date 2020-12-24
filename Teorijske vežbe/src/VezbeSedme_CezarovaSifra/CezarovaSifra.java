package VezbeSedme_CezarovaSifra;

public class CezarovaSifra implements Sifra {
	private int pomeraj;

	public CezarovaSifra(int pomeraj) {
		this.pomeraj = pomeraj;
	}

	public String sifruj(String tekst) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tekst.length(); i++) {
			char c = tekst.charAt(i);
			c += pomeraj;
			sb.append(c);
		}
		return sb.toString();
	}

	public String desifruj(String sifrovan) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sifrovan.length(); i++) {
			char c = sifrovan.charAt(i);
			c -= pomeraj;
		}
		return sb.toString();
	}

}
