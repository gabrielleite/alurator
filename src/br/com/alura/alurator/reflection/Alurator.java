package br.com.alura.alurator.reflection;

import br.com.alura.alurator.protocol.Request;

public class Alurator {
	
	private String basePackage;

	public Alurator(String basePackage) {
		this.basePackage = basePackage;
	}
	
	public Object executa(String url) {
		Request request = new Request(url);
		
		// TODO - processa a requisição executando o método
		// da classe em questão
		
		return null;
	}
}
