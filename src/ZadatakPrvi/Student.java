package ZadatakPrvi;

public class Student {
	
	private int id;
	private String ime, departman;
	double prosek;
	
	private static int idBrojac = 0;
	private static final double odlicanProsek = 9.5;
	
	public Student(String ime, double prosek, String departman) {
		id = idBrojac++;
		this.ime = ime;
		this.prosek = prosek;
		this.departman = departman;
	}
	
	public int getId() {
		return id;
	}
	public String getIme() {
		return ime;
	}
	public String getDepartman() {
		return departman;
	}
	public double getProsek() {
		return prosek;
	}
	
	public String toString() {
		return id + " Student " + ime + ", " + departman + " ima prosek " + prosek;
	}
	
	public boolean dobijaNagradu() {
		return getProsek() >= odlicanProsek;
	}

}
