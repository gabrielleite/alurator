package br.com.alura.alurator.reflexao;

public class ManipuladorObjeto {

	private Object alvo;
	private Class<? extends Object> classe;

	public ManipuladorObjeto(Object alvo) {
		this.alvo = alvo;
		classe = alvo.getClass();
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo) {
		try {
			return new ManipuladorMetodo(alvo, classe.getMethod(nomeMetodo));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
