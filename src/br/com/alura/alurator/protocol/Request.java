package br.com.alura.alurator.protocol;

import java.util.HashMap;
import java.util.Map;

public class Request {
	private String path;
	private Map<String, Object> queryParams;
	private Map<String, String> bodyParams;
	
	public Request(String url) {
//		// v1
//		this.path = url.replaceFirst("/", "");
		
		// v2
		String[] parts = url.replaceFirst("/", "")
				.split("\\?");
		
		this.path = parts[0];
		
		this.queryParams = parts.length > 1
				? new QueryParamsBuilder().withParams(parts[1]).build()
				: new HashMap<>();
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}
	public Map<String, String> getBodyParams() {
		return bodyParams;
	}
	public void setBodyParams(Map<String, String> bodyParams) {
		this.bodyParams = bodyParams;
	}
}
