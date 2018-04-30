package br.com.alura.alurator;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.protocolo.Request;

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
