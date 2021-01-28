package PV04_03;

public class Pacijent {

	private String ime, prezime;
	private int godine;
	
	public Pacijent(String ime, String prezime, int godine) {
		this.ime = ime;
		this.prezime = prezime;
		this.godine = godine;
	}
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public int getGodine() {
		return godine;
	}
	@Override
	public String toString() {
		return "Pacijent [ime=" + ime + ", prezime=" + prezime + ", godine=" + godine + "]";
	}
	
}
