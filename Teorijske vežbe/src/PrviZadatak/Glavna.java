package PrviZadatak;

import java.io.IOException;

public class Glavna {
	public static void main(String[] args) throws IOException {
		Generacija g = new Generacija("res\\studenti.txt");
		g.nagrade("DF");
		Student najbolji = g.najboljiNaDepartmanu("DF");
		System.out.println("Najbolji student na DF  " + najbolji);
	}
}
