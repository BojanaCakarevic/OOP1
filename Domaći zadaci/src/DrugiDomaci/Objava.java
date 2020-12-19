package DrugiDomaci;

public class Objava {
	private String naslov, tema;
	private int brojKomentara;
	
	public Objava(String naslov, String tema, int brojKomentara) {
		this.naslov = naslov;
		setTema(tema);
		setBrojKomentara(brojKomentara);
	}
	
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		if(tema.equals("sport") || tema.equals("hobiji") ||
				tema.equals("strani jezici") || tema.equals("razno"))
			this.tema = tema;
		else
			this.tema = "razno";
	}
	public int getBrojKomentara() {
		return brojKomentara;
	}
	public void setBrojKomentara(int brojKomentara) {
		this.brojKomentara = brojKomentara;
	}

	public String toString() {
		return naslov + " [" + tema + "] - " + brojKomentara;
	}
	
}
