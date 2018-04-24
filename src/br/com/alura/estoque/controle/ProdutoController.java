package br.com.alura.estoque.controle;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.estoque.dao.ProdutoDaoMock;
import br.com.alura.estoque.modelo.Produto;

public class ProdutoController {
	
	private ProdutoDaoMock produtoDao;

	public ProdutoController() {
		produtoDao = new ProdutoDaoMock();
	}
	
	public List<Produto> index() {
		return produtoDao.lista();
	}
	
	public Produto index(Integer id) {
		return produtoDao.getProduto(id);
	}
	
	public List<Produto> filter(String name) {
		return produtoDao.lista().stream()
							.filter(produto -> produto.getNome().toLowerCase().startsWith(name.toLowerCase()))
							.collect(Collectors.toList());
	}
	
	public List<Produto> filter(String name, String brand) {
		return produtoDao.lista().stream()
							.filter(product -> 
								product.getNome().toLowerCase().startsWith(name.toLowerCase())
								&& product.getMarca().equalsIgnoreCase(brand)
							)
							.collect(Collectors.toList());
	}
}
