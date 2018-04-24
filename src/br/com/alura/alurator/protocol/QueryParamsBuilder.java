package br.com.alura.alurator.protocol;

import java.util.HashMap;
import java.util.Map;

public class QueryParamsBuilder {
	private Map<String, Object> queryParams = new HashMap<>();

	public QueryParamsBuilder withParams(String stringQueryParams) {
		String[] stringParams = stringQueryParams.split("&");
		
		for (String stringParam : stringParams) {
//			System.out.println(stringParam);
			String[] paramPair = stringParam.split("=");
			
			String keyParam = paramPair[0];
			Object valueParam = paramPair[1];
			
			queryParams.put(keyParam, valueParam);
		}
		
		return this;
	}
	
	public Map<String, Object> build() {
		return this.queryParams;
	}

}
