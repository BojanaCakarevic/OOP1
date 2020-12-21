package SestiZadatak;

public class Blog extends WebSajt {

	private Post[] postovi;
	
	public Blog(String adresa, Post[] postovi) {
		super(adresa);
		this.postovi = postovi;
	}

	public static class Post{
		
		private String sadrzaj;
		private int brojLajkova;
		private int brojKomentara;
		
		public String getSadrzaj() {
			return sadrzaj;
		}
		public int getBrojLajkova() {
			return brojLajkova;
		}
		public int getBrojKomentara() {
			return brojKomentara;
		}

		public Post(String sadrzaj, int brojLajkova, int brojKomentara) {
			super();
			this.sadrzaj = sadrzaj;
			this.brojLajkova = brojLajkova;
			this.brojKomentara = brojKomentara;
		}
		
		int popularnostPosta() {
			return brojLajkova * 5 + brojKomentara * 12;
		}
		
	}
	
	@Override
	double cenaReklameNaSajtu() {
		double ukupno = 0.0;
		for(Post p : postovi) {
			ukupno += p.popularnostPosta();
		} return ukupno * 1.5;
	}

	@Override
	boolean odobrenoKomentarisanje() {
		for(Post p: postovi){
			if(p.brojKomentara >= 1)
				return true;
		} return false;
		}

}
