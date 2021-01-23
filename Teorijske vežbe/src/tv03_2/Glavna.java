package tv03_2;

import java.io.IOException;

public class Glavna {
	public static void main(String[] args) throws IOException {
		
		FudbalskiTim ft = new FudbalskiTim("res\\fudbaleri.txt");
		System.out.println("Rezervni igraci su: ");
		Fudbaler[] r = ft.izdvojRezerve();
		for (int i = 0; i < r.length; i++ ) {
			System.out.println(r[i]);
		}
		SredisnjiIgrac najbolji = ft.najboljiSredisnjiIgracUrezervi();
		System.out.println("Najbolji sredisnji igrac je " + najbolji);
	}
}
