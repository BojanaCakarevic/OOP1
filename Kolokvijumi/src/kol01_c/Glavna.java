package kol01_c;

import java.io.IOException;

public class Glavna {

	public static void main(String[] args) throws IOException {
		Prodavnica p = new Prodavnica("res\\uredjaji.txt");
		System.out.println( "Prosecna cena prodatih uredjaja je " + p.prodaj());
		p.popravi();
	}

}
