package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;

public class Alurator {
	
	private String basePackage;

	public Alurator(String basePackage) {
		this.basePackage = basePackage;
	}
	
	public Object executa(String url) {
		Request request = new Request(url);
		
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		
		return null;
	}
}
