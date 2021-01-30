package kol01_a;


public class Adidas extends Patike {

	public  Adidas(int broj, String brend) {
		super (" ", " ", " ", 0.0, broj, "Adidas");
		
		setTip(inicijalizacijaTipa());
		setVrsta(inicijalizujVrstu());
		setBoja(inicijalizujBoju());
		setCena(inicijalizujCenu());
	
	}

	public String inicijalizacijaTipa() {
		if (Osobine.rng.nextInt(100) <= 60) 
			return Osobine.TIP[0]; 
			else 
				return Osobine.TIP[1];	
	}
	
}
