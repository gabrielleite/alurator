package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorMetodo {
	
	private Object alvo;
	private Method metodo;

	public ManipuladorMetodo(Object alvo, Method metodo) {
		this.alvo = alvo;
		this.metodo = metodo;
	}

	public Object invocar(Map<String, Object> args) {
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
			e.printStackTrace();
			throw new RuntimeException("Erro no método!", e.getTargetException());
		}
	}
}
