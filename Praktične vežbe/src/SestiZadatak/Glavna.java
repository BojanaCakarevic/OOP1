package SestiZadatak;

import java.io.IOException;

public class Glavna {

		public static void main(String[] args) throws IOException {
			OmiljeniSajtovi omiljeniSajtovi = new OmiljeniSajtovi("res\\sajtovi.txt");
			double budzet = 10000;
			WebSajt rezultat = null;
			while(budzet > 0 || rezultat != null) {
				rezultat = omiljeniSajtovi.gdeDaPostavimReklamu(budzet);
				if(rezultat == null)
					break;
			} 
			budzet -= rezultat.cenaReklameNaSajtu();
			System.out.println(rezultat);
		}

}
