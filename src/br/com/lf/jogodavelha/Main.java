package br.com.lf.jogodavelha;

public class Main {
	
	public static void main(String[] args) {
		long tempoInicio = System.currentTimeMillis();
		//C�digo do programa...
		
		JogadorRobo robo = new JogadorRobo();
		robo.iniciarInteligencia();
		
		System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));
		//O c�digo acima ir� te retornar o tempo gasto em milisegundos...
		
	}

}
