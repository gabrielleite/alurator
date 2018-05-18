package br.com.alura.alurator.conversor;

import java.lang.reflect.Field;
import java.util.Collection;

public class ConversorXML {
	public String converte(Object objeto) {
		try {
			Class<?> classeObjeto = objeto.getClass();
			StringBuilder xml = new StringBuilder();
			
			if (objeto instanceof Collection) {
				Collection<?> collection = (Collection<?>) objeto;
				xml.append("<lista>");
				for (Object o : collection) {
					xml.append(converte(o));
				}
				xml.append("</lista>");
			} else {
				
	//			for (Annotation annotation : clazz.getAnnotations()) {
	//				Class<? extends Annotation> type = annotation.annotationType();
	//	            System.out.println("Values of " + type.getName());
	//
	//	            for (Method method : type.getDeclaredMethods()) {
	//	                Object value = method.invoke(annotation, (Object[])null);
	//	                System.out.println(" " + method.getName() + ": " + value);
	//	            }
	//			}
				
				String className = classeObjeto.getName();
						
				xml.append("<"+className+">");
				
				Field[] fields = classeObjeto.getDeclaredFields();
				
				String content = "";
				for (Field f : fields) {
					f.setAccessible(true);
					String fieldName = f.getName();
					
					Object fieldValue = f.get(objeto);
					content += "<"+fieldName+">"
							 + fieldValue
							 + "</"+fieldName+">" ;
				}
				
				xml.append(content);
				xml.append("</"+className+">");
			}
			
			return xml.toString();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao converter para XML!");
		}
	}
}
