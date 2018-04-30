package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipuladorMetodo {
	
	private Object alvo;
	private Method metodo;

	public ManipuladorMetodo(Object alvo, Method metodo) {
		this.alvo = alvo;
		this.metodo = metodo;
	}

	public Object invocar() {
		try {
			return metodo.invoke(alvo);
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
