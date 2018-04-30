package br.com.alura.alurator.protocolo;

public class Request {
	
	private String nomeControle;
	private String nomeMetodo;

	public Request(String url) {
		String[] partesUrl = url.replaceFirst("/", "")
								.split("/");
		
		nomeControle = partesUrl[0];
		nomeControle = Character.toUpperCase(nomeControle.charAt(0))
				+ nomeControle.substring(1)
				+ "Controller";
		
		nomeMetodo = partesUrl[1];
	}
	
	public String getNomeControle() {
		return nomeControle;
	}
	
	public String getNomeMetodo() {
		return nomeMetodo;
	}
}
