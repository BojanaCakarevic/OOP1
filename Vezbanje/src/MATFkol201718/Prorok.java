package MATFkol201718;


public class Prorok {
	private String ime;
	private int ostvarenaPror, ukupnoPror;

	public Prorok(String ime, int ostvarenaPror, int ukupnoPror) {
		this.ime = ime;
		this.ostvarenaPror = ostvarenaPror;
		this.ukupnoPror = ukupnoPror;
	}

	public String getIme() {
		return ime;
	}

	public int getOstvarenaPror() {
		return ostvarenaPror;
	}

	public int getUkupnoPror() {
		return ukupnoPror;
	}

	void zabeleziIshodProrocanstva(boolean status) {
		ukupnoPror++;
		if (status)
			ostvarenaPror++;
	}

	@Override
	public String toString() {
		return "ime: " + ime + ",uspelo: " + ostvarenaPror + ", ukupno: " + ukupnoPror;
	}

}
