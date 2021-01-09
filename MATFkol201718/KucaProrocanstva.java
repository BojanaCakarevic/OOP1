package MATFkol201718;

import java.util.Scanner;

public class KucaProrocanstva {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TarotKarta tk1 = new TarotKarta(0, "Visoka Svestenica", "Italija");
        TarotKarta tk2 = new TarotKarta(1, "Lazov", "Otomansko Carstvo");
        TarotKarta tk3 = new TarotKarta(-1, "Mag", "Nemacka");
      
        System.out.println("Unesite ime proroka (jedna rec):");
        String ime = sc.next();
        System.out.println("Unesite broj ostvarenih prorocanstava:");
        int ostvareno = sc.nextInt();
        System.out.println("Unesite ukupan broj prorocanstava:");
        int ukupno = sc.nextInt();
        TarotKarta[] karte = {tk1, tk2, tk3};
        TarotProrok tarotProrok = new TarotProrok(ime, ostvareno, ukupno, karte);
        System.out.println();

        System.out.println("Unesi ime proroka (jedna rec):");
        ime = sc.next();
        System.out.println("Unesi broj ostvarenih prorocanstava:");
        ostvareno = sc.nextInt();
        System.out.println("Unesi ukupan broj prorocanstava:");
        ukupno = sc.nextInt();
        System.out.println("Unesi tip kristala (jedna rec)");
        String tipKristala = sc.next();
        KuglaProrok kuglaProrok =new KuglaProrok(ime, ostvareno, ukupno, tipKristala);
        System.out.println();

        System.out.println(tarotProrok);
        System.out.println("Procenat uspesnosti: " + tarotProrok.getOstvarenaPror() );

        System.out.println(kuglaProrok);
        System.out.println("Procenat uspesnosti: " + kuglaProrok.getOstvarenaPror() );
        System.out.println();

        System.out.println(tarotProrok.getIme() + " prorice: " + tarotProrok.proreci(tk1));
        System.out.println(kuglaProrok.getIme() + " prorice: " + kuglaProrok.prorekni());

        sc.close();
	}
}
