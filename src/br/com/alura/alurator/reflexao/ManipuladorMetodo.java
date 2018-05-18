package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ManipuladorMetodo {
	
	private Object alvo;
	private Method metodo;
	private Map<String, Object> args;
	private BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao;

	public ManipuladorMetodo(Object alvo, Method metodo, Map<String, Object> args) {
		this.alvo = alvo;
		this.metodo = metodo;
		this.args = args;
	}
	
	public ManipuladorMetodo comTratamentoDeExcecao(BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao) {
		this.tratamentoExcecao = tratamentoExcecao;
		return this;
	}

	public Object invocar() {
		List<Object> parametros = new ArrayList<>();
		Stream.of(metodo.getParameters())
				.forEach(p -> parametros.add(args.get(p.getName())));
		try {
			return metodo.invoke(alvo, parametros.toArray());
		} catch (IllegalAccessException
				| IllegalArgumentException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			if (tratamentoExcecao != null) {
				return tratamentoExcecao.apply(metodo, e);
			}
			
			e.printStackTrace();
			throw new RuntimeException("Erro no método!", e.getTargetException());
		}
	}
}
