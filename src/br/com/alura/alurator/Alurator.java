package br.com.alura.alurator;

import java.lang.reflect.InvocationTargetException;

public class Alurator {
	
	private String basePackage;

	public Alurator(String basePackage) {
		this.basePackage = basePackage;
	}
	
	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		
		String[] partesUrl = url.replaceFirst("/", "")
				.split("/");

		String nomeControle = partesUrl[0];
		
		nomeControle = Character.toUpperCase(nomeControle.charAt(0))
								+ nomeControle.substring(1)
								+ "Controller";
		
		try {
			Class<?> classeControle = Class.forName(basePackage + nomeControle);
			
			Object instanciaControle = classeControle.getConstructor().newInstance();
			
			System.out.println(instanciaControle);
			
			return null;
		} catch (ClassNotFoundException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException 
				| NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro no construtor!", e.getTargetException());
		}
	}
}
