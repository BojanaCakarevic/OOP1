package kolokvijum01_02;

import java.io.IOException;

public class Glavna {

	public static void main(String[] args) throws IOException {
		Prodavnica p = new Prodavnica("res\\uredjaji.txt");
		p.prodaj();
		p.popravi();
	}

}
