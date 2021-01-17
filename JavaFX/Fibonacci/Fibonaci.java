package Fibonacci;

public class Fibonaci {

	private int trenutni, prethodni;
	
	public Fibonaci() {
		this.prethodni = 0;
		this.trenutni = 1;
	}
	
	public int manji() {
		int pom = trenutni;
		trenutni = prethodni;
		prethodni = pom - trenutni;
		
		return pom;
	}
	
	public int veci() {
		int pom = prethodni + trenutni;
		prethodni = trenutni;
		trenutni = pom;
		
		return pom;
	}
}
