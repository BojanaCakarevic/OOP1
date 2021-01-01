package ZadatakPrvi;

public class Matrica {

	private int[][] m;
	private int dim;
	private int[] prethodni;
	private int brParnih, brNeparnih;

	public Matrica(int dim, int brojPrethodnih) {
		this.dim = dim;
		this.m = new int[this.dim][this.dim];
		this.brNeparnih = 0;
		this.brParnih = 0;
		
		for (int i = 0; i < this.dim; i++) {
			for (int j = 0; j < this.dim; j++) {
				this.m[j][i] = i * dim + j + 1;
			}
		}

		this.prethodni = new int[brojPrethodnih];
	}

	public int brojNaLokaciji(int i, int j) {
		return this.m[i][j];
	}

	public boolean sviIsti() {
		for (int i = 0; i < this.prethodni.length - 1; i++) {
			if (this.prethodni[i] != this.prethodni[i + 1])
				return false;
		}
		return true;
	}

	public int getBrParnih() {
		return this.brParnih;
	}

	public int getBrNeparnih() {
		return this.brNeparnih;
	}

	public void odaberiBroj(int broj) {
		for(int i = 0; i < this.prethodni.length - 1; i++) {
			this.prethodni[i] = this.prethodni[i+1];
		} this.prethodni[this.prethodni.length-1] = broj;
		if(broj % 2 == 0)
			this.brParnih++;
		else
			this.brNeparnih++;
	}
	
}
