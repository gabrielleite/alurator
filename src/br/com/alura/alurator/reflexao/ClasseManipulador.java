package br.com.alura.alurator.reflexao;

public class ClasseManipulador {

	private Class<?> classe;

	public ClasseManipulador(Class<?> classe) {
		this.classe = classe;
	}
	
	public ConstrutorManipulador getConstrutorPadrao() {
		try {
			return new ConstrutorManipulador(classe.getConstructor());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
