package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
	
	private String nomeControle;
	private String nomeMetodo;
	private Map<String, Object> queryParams;

	public Request(String url) {
		String[] partesUrl = url.replaceFirst("/", "")
								.split("\\?");
		
		String[] controladorEMetodo = partesUrl[0].split("/");
		nomeControle = controladorEMetodo[0];
		nomeControle = Character.toUpperCase(nomeControle.charAt(0))
				+ nomeControle.substring(1)
				+ "Controller";
		
		nomeMetodo = controladorEMetodo[1];
		
		queryParams = partesUrl.length > 1
				? new QueryParamsBuilder().comParametros(partesUrl[1]).build()
				: new HashMap<>();
	}
	
	public String getNomeControle() {
		return nomeControle;
	}
	
	public String getNomeMetodo() {
		return nomeMetodo;
	}
	
	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
}
