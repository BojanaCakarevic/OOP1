package TreciZadatak;

import java.io.IOException;

public class Glavna {
	public static void main(String[] args) throws IOException {
		Galerija galerija = new Galerija();
		double prosek = galerija.prosecnaVrednost();
		System.out.println("Prosecna vrednost dela svih slikara je " + prosek);
	}
}
