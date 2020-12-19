package DrugiZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SkolaJezika {

	private Kurs[] kursevi;

	public SkolaJezika(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brojKurseva = Integer.parseInt(br.readLine());
		kursevi = new Kurs[brojKurseva];

		for (int i = 0; i < brojKurseva; i++) {
			String[] s = br.readLine().split(",");

			String jezik = s[0].trim();
			String nivo = s[1].trim();
			int brPolaznika = Integer.parseInt(s[2].trim());

			kursevi[i] = new Kurs(jezik, nivo, brPolaznika);
		}
		br.close();
	}

	String najnaprednijiJezik() {
		Kurs najnapredniji = null;
		for (int i = 0; i < kursevi.length; i++) {
			if (najnapredniji == null || (kursevi[i].getNivo().compareTo("napredni") == 0 && 
			kursevi[i].getBrPolaznika() > najnapredniji.getBrPolaznika()))
					najnapredniji = kursevi[i];
			}
		return najnapredniji.getJezik();
	}

	void unaprediGrupu(String jezik, String nivo) {
		String povecanNivo = null;
		if (nivo == "osnovni")
			povecanNivo = "srednji";
		else if (nivo == "srednji")
			povecanNivo = "napredni";
		else
			return;

		for (int i = 0; i < kursevi.length; i++) {
			if (kursevi[i].getJezik().equals(jezik) && kursevi[i].getNivo().equals(povecanNivo))
				System.out.println("Potrebno je spojiti dve grupe");
		}
	}

}
