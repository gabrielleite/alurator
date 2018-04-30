package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {
	
	private String basePackage;

	public Alurator(String basePackage) {
		this.basePackage = basePackage;
	}
	
	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		Request request = new Request(url);
		
		String nomeControle = request.getNomeControle();
		
		Object instanciaControle = new Reflexao()
										.refleteClasse(basePackage + nomeControle)
										.getConstrutorPadrao()
										.invocar();
			
		System.out.println(instanciaControle);
		
		return null;
	}
}
