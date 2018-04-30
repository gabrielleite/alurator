package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstrutorManipulador {

	private Constructor<?> construtor;

	public ConstrutorManipulador(Constructor<?> construtor) {
		this.construtor = construtor;
	}
	
	public Object invocar() {
		try {
			return construtor.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro no construtor!", e.getTargetException());
		}
	}
}
