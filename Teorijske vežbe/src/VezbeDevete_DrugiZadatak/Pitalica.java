package VezbeDevete_DrugiZadatak;

public class Pitalica {
	public static void main(String[] args) {
		try {
			SetInterface<Integer> s = new SetList<Integer>();
			for (int i = 0; i < 20; i++) {
				int num = (int) (Math.random() * 10);
				s.add(num);
				s.add(num);
			}
		} catch (SetException se) {
			System.out.println("Koliko brojeva je dodato u skup?");
		}
	}
}
