package ZadatakPrvi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Generacija {
	private Student[] studenti;
	
	public Generacija(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		
		int brStudenata = Integer.parseInt(br.readLine());
		studenti = new Student[brStudenata];
		
		for(int i = 0;  i < brStudenata; i++) {
			String[] s = br.readLine().split(",");
			String ime = s[0].trim();
			double prosek = Double.parseDouble(s[1].trim());
			String departman = s[2].trim();
			
			studenti[i] = new Student(ime, prosek, departman);
		}
			br.close();
	}
	
	public void nagrade(String departman) {
		int brojac = 0;
		System.out.println("Nagradjeni studenti su: ");
		
		for(int i=0; i<studenti.length; i++) {
			if(studenti[i].getDepartman().compareTo(departman) == 0) {
				if(studenti[i].dobijaNagradu()) {
					System.out.print(studenti[i]);
					brojac++;
				}
			}
		}
		System.out.println("Najboljih studenata ima " + brojac);
	}
	
	public Student najboljiNaDepartmanu(String departman) {
		Student najbolji = null;
		for(int i=0; i<studenti.length; i++) {
			if(studenti[i].getDepartman().compareTo(departman) == 0) {
				if(najbolji == null)
					najbolji = studenti[i];
				else {
					if(studenti[i].getProsek() > najbolji.getProsek())
						najbolji = studenti[i];
				}
			}
		}
		return najbolji;
	}
	
}
