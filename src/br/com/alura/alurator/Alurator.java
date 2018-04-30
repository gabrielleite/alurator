package br.com.alura.alurator;

import java.util.Map;

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
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> queryParams = request.getQueryParams();
		
		Object retorno = new Reflexao().refleteClasse(basePackage + nomeControle)
										.criaInstancia()
										.getMetodo(nomeMetodo, queryParams)
										.invocar(queryParams);
		
		System.out.println(retorno);
		
		return retorno;
	}
}
