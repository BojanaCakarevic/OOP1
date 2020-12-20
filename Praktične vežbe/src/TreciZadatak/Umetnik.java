package TreciZadatak;

public class Umetnik {
	private String ime;
	private UmetnickoDelo[] dela;
	private int brojDela;
	
	public Umetnik(String ime, int maks) {
		this.ime = ime;
		dela = new UmetnickoDelo[maks];
		brojDela = 0;
	}

	public String getIme() {
		return ime;
	}

	public UmetnickoDelo[] getDela() {
		return dela;
	}
	public int getBrojDela() {
		return brojDela;
	}
	
	public boolean izlozi(UmetnickoDelo delo) {
		if(brojDela < dela.length) {
			dela[brojDela++] = delo;
			return true;
		} else
			return false;
	}
	
	public double vrednost() {
		double ukupno = 0.0;
		for(int i = 0; i < brojDela; i++) {
			ukupno += dela[i].getCena();
		}
		return ukupno;
	}
	
	
}
