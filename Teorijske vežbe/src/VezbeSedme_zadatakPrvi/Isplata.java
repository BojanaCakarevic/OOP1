package VezbeSedme_zadatakPrvi;

import java.util.Scanner;

public class Isplata {
	public static void main(String[] args) {
	Apoen[] moguciApoeni = {
			Apoen.JEDAN,
			Apoen.DVA,
			Apoen.PET,
			Apoen.DESET,
			Apoen.DVADESET_PET,
			Apoen.PEDESET,
			Apoen.STO
	};
	
	Scanner sc=new Scanner(System.in);  
    
	   System.out.println("Unesite iznos za isplatu ");  
	   int svota =sc.nextInt();  
	   System.out.println("Optimalna isplata za " + svota + " je ");
	   sc.close();  
	   
	   for(int i = moguciApoeni.length - 1 ; i >= 0; i--) {
		   int vrednostApoena = moguciApoeni[i].getVrednost();
		   String opisApoena = moguciApoeni[i].getOpis();
		   
		   int brojNovcanica = svota / vrednostApoena;
		   svota = svota % vrednostApoena;
		   
		   if(brojNovcanica > 0)
			   System.out.println(brojNovcanica + " x " + opisApoena);
	   }
	 
	}
}
