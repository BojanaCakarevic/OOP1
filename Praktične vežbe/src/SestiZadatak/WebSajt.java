package SestiZadatak;

public abstract class WebSajt implements URLAadresirano {
	
	private String adresa;
		
	public WebSajt(String adresa) {
		this.adresa = adresa;
	}

	@Override
	public String adresa() {
		return adresa;
	}
	
	abstract double cenaReklameNaSajtu();
	abstract boolean odobrenoKomentarisanje();

	@Override
	public String toString() {
		return "Web sajt sa adresom " + adresa() + ", cenom reklame " + cenaReklameNaSajtu() 
			+ ", na kom " + (odobrenoKomentarisanje() ? "je" : "nije") + " odobreno komentarisanje";
	}
	
	
}
