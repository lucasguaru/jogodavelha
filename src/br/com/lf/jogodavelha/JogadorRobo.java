package br.com.lf.jogodavelha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JogadorRobo {
	
	private int vitorias = 0;
	
	public void iniciarInteligencia() {
		
		int[] tabuleiro = new int[9];
		for (int i = 0; i < tabuleiro.length; i++) {
			tabuleiro[i] = -1;
		}
		iniciarRecursivo(tabuleiro);
		System.out.println("Vitorias: " + vitorias);
		
	}
	
	public boolean iniciarRecursivo(int[] tabuleiro) {
		boolean vitoria = false;
		
		if (ehVitoria(tabuleiro)) {
			print(tabuleiro);
			return true;
		}
		
		List<Integer> posicoesLivres = getPosicoesLivres(tabuleiro);

		for (int i = 0; i < posicoesLivres.size(); i++) {
			vitoria = iniciarRecursivo(cloneTabuleiro(tabuleiro, posicoesLivres.get(i)));
			if (vitoria) {
				vitorias++;
			}
		}
		return vitoria;
	}
	
	private void print(int[] tabuleiro) {
//		System.out.println(Arrays.toString(tabuleiro));
	}

	private boolean ehVitoria(int[] tabuleiro) {
		int jogadas = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i] > -1) {
				jogadas++;
			}
		}
		
		if (jogadas > 4) {
			if (isVitoriaLinha(tabuleiro, jogadas - 1)) {
				return true;
			}
			if (isVitoriaColuna(tabuleiro, jogadas - 1)) {
				return true;
			}
			if (isVitoriaDiagonal(tabuleiro, jogadas - 1)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean isVitoriaDiagonal(int[] tabuleiro, int ultimaPosicao) {
		int ultimaJogada = tabuleiro[ultimaPosicao];
		//caso sejam posicoes que nao faze diagonais, retorna falso
		if (ultimaJogada == 1 || ultimaJogada == 3 || ultimaJogada == 5 || ultimaJogada == 7) {
			return false;
		}
		if (ultimaJogada == 0 || ultimaJogada == 8) {
			return isVitoriaDiagonalEsquerda(tabuleiro, ultimaPosicao);
		} else if (ultimaJogada == 2 || ultimaJogada == 6) {
			return isVitoriaDiagonalDireita(tabuleiro, ultimaPosicao);
		} else {
			return isVitoriaDiagonalEsquerda(tabuleiro, ultimaPosicao) || isVitoriaDiagonalDireita(tabuleiro, ultimaPosicao);
		}
	}
	
	private boolean isVitoriaDiagonalEsquerda(int[] tabuleiro, int ultimaPosicao) {
		int contAcertos = 0;
		for (int i = (ultimaPosicao % 2); i < tabuleiro.length; i+=2) {
			if (tabuleiro[i] == 0 || tabuleiro[i] == 4 || tabuleiro[i] == 8) {
				if (++contAcertos == 3) {
					return true;
				}
			}
		}
		return false;		
	}
	
	private boolean isVitoriaDiagonalDireita(int[] tabuleiro, int ultimaPosicao) {
		int contAcertos = 0;
		for (int i = (ultimaPosicao % 2); i < tabuleiro.length; i+=2) {
			if (tabuleiro[i] == 2 || tabuleiro[i] == 4 || tabuleiro[i] == 6) {
				if (++contAcertos == 3) {
					return true;
				}
			}
		}
		return false;		
	}

	private boolean isVitoriaColuna(int[] tabuleiro, int ultimaPosicao) {
		int contAcertos = 0;
		int coluna = tabuleiro[ultimaPosicao] % 3;
			
		for (int i = (ultimaPosicao % 2); i < tabuleiro.length; i+=2) {
			if (tabuleiro[i] == coluna || tabuleiro[i] == (coluna + 3) || tabuleiro[i] == (coluna + 6)) {
				if (++contAcertos == 3) {
					return true;
				}
			}
		}
		
		return false;
		
	}

	private boolean isVitoriaLinha(int[] tabuleiro, int ultimaPosicao) {
		int contAcertos = 0;
		int linha = tabuleiro[ultimaPosicao] / 3;
			
		for (int i = (ultimaPosicao % 2); i < tabuleiro.length; i+=2) {
			if (tabuleiro[i] == (linha * 3) || tabuleiro[i] == ((linha * 3) + 1) || tabuleiro[i] == ((linha * 3) + 2)) {
				if (++contAcertos == 3) {
					return true;
				}
			}
		}
		
		return false;
	}

	public List<Integer> getPosicoesLivres(int[] tabuleiro) {
		boolean[] posicoesUsadas = new boolean[] {false, false, false, false, false, false, false, false, false};
		
		List<Integer> posicoesLivres = new ArrayList<>();
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i] > -1) {
				posicoesUsadas[tabuleiro[i]] = true;
			}
		}
		
		for (int i = 0; i < posicoesUsadas.length; i++) {
			if (posicoesUsadas[i] == false) {
				posicoesLivres.add(i);
			}
		}
		
		return posicoesLivres;
	}
	
	private int[] cloneTabuleiro(int[] tabuleiro, int posicao) {
		int[] clone = tabuleiro.clone();
		for (int i = 0; i < clone.length; i++) {
			if (clone[i] == -1) {
				clone[i] = posicao;
				break;
			}
		}
		return clone;
	}
	

}
