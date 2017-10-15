package br.com.lf.jogodavelha;

public class Tabuleiro {

	private int[][] tabuleiro = new int[3][3];
	private int countJogadas;
	private int nome;

	public static int[] POSICAO_1 = new int[] {0,0};
	public static int[] POSICAO_2 = new int[] {0,1};
	public static int[] POSICAO_3 = new int[] {0,2};
	public static int[] POSICAO_4 = new int[] {1,0};
	public static int[] POSICAO_5 = new int[] {1,1};
	public static int[] POSICAO_6 = new int[] {1,2};
	public static int[] POSICAO_7 = new int[] {2,0};
	public static int[] POSICAO_8 = new int[] {2,1};
	public static int[] POSICAO_9 = new int[] {2,2};

	public Tabuleiro(int nome) {
		this.nome = nome;
		zerarTabuleiro();
	}

	public void zerarTabuleiro() {
		for (int linha = 0; linha < 3; linha++)
			for (int coluna = 0; coluna < 3; coluna++)
				tabuleiro[linha][coluna] = 0;

		countJogadas = 0;
	}

	public int getPosicao(int[] tentativa) {
		return tabuleiro[tentativa[0]][tentativa[1]];
	}

	public void jogar(int[] tentativa, int jogador) {
		if (jogador == 1)
			tabuleiro[tentativa[0]][tentativa[1]] = -1;
		else
			tabuleiro[tentativa[0]][tentativa[1]] = 1;
		
		countJogadas++;
		exibeTabuleiro();
	}

	public int checaLinhas() {
		for (int linha = 0; linha < 3; linha++) {

			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
				return -1;
			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
				return 1;
		}

		return 0;

	}

	public int checaColunas() {
		for (int coluna = 0; coluna < 3; coluna++) {
			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
				return -1;
			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
				return 1;
		}

		return 0;

	}

	public int checaDiagonais() {
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
			return -1;
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
			return 1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
			return -1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
			return 1;

		return 0;
	}
	
	 public boolean tabuleiroCompleto() {
		 return (this.countJogadas >= 9);
	 }

		public void exibeTabuleiro() {
			System.out.println();
			for (int linha = 0; linha < 3; linha++) {

				for (int coluna = 0; coluna < 3; coluna++) {

					if (tabuleiro[linha][coluna] == -1) {
						System.out.print(" X ");
					}
					if (tabuleiro[linha][coluna] == 1) {
						System.out.print(" O ");
					}
					if (tabuleiro[linha][coluna] == 0) {
						System.out.print("   ");
					}

					if (coluna == 0 || coluna == 1)
						System.out.print("|");
				}
				System.out.println();
			}

		}

}
