package kol01_b;

import java.io.IOException;

public class Glavna {

	public static void main(String[] args) throws IOException {
		Kafana k = new Kafana("res\\pivoteka.txt", "Ribar", "Novi Sad");
		k.posluziPivo();
		System.out.println("Prosecna jacina piva u kafani je " + k.prosecnaJacina() );
	}
	
}
