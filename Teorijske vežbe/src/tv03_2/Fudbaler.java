package tv03_2;

public class Fudbaler {

	private String ime;
	private boolean prvaPostava;
	
	public Fudbaler (String ime, boolean prvaPostava) {
		this.ime = ime;
		this.prvaPostava = prvaPostava;
	}
	
	public String getIme() {
		return ime;
	}
	public boolean isPrvaPostava() {
		return prvaPostava;
	}
	
	public String toString() {
		if(prvaPostava)
			return  "Fudbaler " + ime + " je u prvoj postavi.";
		else
			return "Fudbaler " + ime + " nije u prvoj postavi";
	}
	
}
