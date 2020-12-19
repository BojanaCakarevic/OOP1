package DrugiDomaci;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Forum {
	private Objava[] objave;

	public Forum(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brObjava = Integer.parseInt(br.readLine());
		objave = new Objava[brObjava];

		for (int i = 0; i < brObjava; i++) {
			String[] s = br.readLine().split(",");

			String naslov = s[0].trim();
			String tema = s[1].trim();
			int brojKomentara = Integer.parseInt(s[2].trim());

			objave[i] = new Objava(naslov, tema, brojKomentara);
		}
		br.close();
	}

	Objava najpopularnijaObjava(String tema) {
		Objava najpopularnija = null;
		int maks = 0;
		for (int i = 0; i < objave.length; i++) {
			if (objave[i].getTema().equals(tema) && objave[i].getBrojKomentara() > maks) {
				maks = objave[i].getBrojKomentara();
				najpopularnija = objave[i];
			}
		}
		if (najpopularnija != null)
			return najpopularnija;
		else {
			System.out.println("Rezultat nije pronadjen");
			return null;
		}
	}

	void statistika() {
		int sportO = 0;
		int sportK = 0;
		int hobijiO = 0;
		int hobijiK = 0;
		int jeziciO = 0;
		int jeziciK = 0;
		int raznoO = 0;
		int raznoK = 0;

		for (int i = 0; i < objave.length; i++) {
			if (objave[i].getTema().equals("sport")) {
				sportO++;
				sportK += objave[i].getBrojKomentara();
			} else if (objave[i].getTema().equals("hobiji")) {
				hobijiO++;
				hobijiK += objave[i].getBrojKomentara();
			} else if (objave[i].getTema().equals("strani jezici")) {
				jeziciO++;
				jeziciK += objave[i].getBrojKomentara();
			} else {
				raznoO++;
				raznoK += objave[i].getBrojKomentara();
			}
		}
		System.out.println();
		System.out.println("Sport [objave: " + sportO + "] [komentari: " + sportK + "]");
		System.out.println("Hobiji [objave: " + hobijiO + "] [komentari: " + hobijiK + "]");
		System.out.println("Strani jezici [objave: " + jeziciO + "] [komentari: " + jeziciK + "]");
		System.out.println("Razno [objave: " + raznoO + "] [komentari: " + raznoK + "]");
	}

}
