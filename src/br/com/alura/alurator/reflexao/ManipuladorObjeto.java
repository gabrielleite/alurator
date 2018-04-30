package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {

	private Object alvo;
	private Class<? extends Object> classe;

	public ManipuladorObjeto(Object alvo) {
		this.alvo = alvo;
		classe = alvo.getClass();
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> args) {
		Stream<Method> metodos = Stream.of(classe.getDeclaredMethods());
		Method metodoSelecionado = metodos.filter(metodo -> metodo.getName().equals(nomeMetodo) 
									&& metodo.getParameterCount() == args.values().size()
									&& Stream.of(metodo.getParameters())
											.allMatch(param ->
												args.keySet().contains(param.getName()) &&
												args.get(param.getName()).getClass().equals(param.getType())
											)
									)
								.findFirst()
								.orElseThrow(() -> new RuntimeException("Método não encontrado!"));
		return new ManipuladorMetodo(alvo, metodoSelecionado);
	}
}
