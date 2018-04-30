package br.com.alura.alurator.reflexao;

public class Reflexao {
	public Class<?> getClasse(String fqn) {
		try {
			return Class.forName(fqn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public ClasseManipulador refleteClasse(String fqn) {
		return new ClasseManipulador(getClasse(fqn));
	}
}
