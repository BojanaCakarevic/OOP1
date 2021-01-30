package kol01_a;


public class Nike extends Patike {

	public  Nike(int broj, String brend) {
		super (" ", " ", " ", 0.0, broj, "Nike");
		
		setTip( inicijalizacijaTipa());
		setVrsta(inicijalizujVrstu());
		setBoja(inicijalizujBoju());
		setCena(inicijalizujCenu());
	
	}

	public String inicijalizacijaTipa() {
		if (Osobine.rng.nextInt(100) <= 70) 
			return Osobine.TIP[0]; 
			else 
				return Osobine.TIP[1];	
	}

}
