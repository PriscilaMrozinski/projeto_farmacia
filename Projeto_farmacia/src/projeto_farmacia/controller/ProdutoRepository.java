package projeto_farmacia.controller;

import projeto_farmacia.model.Produto;

//Implementando a Interface
public interface ProdutoRepository {
	void cadastrarProdutos(Produto produto);
	void listarProdutos();
	void buscarProdutos(int codigo);
	void atualizarProdutos(Produto produto);
	void excluirProdutos(int codigo);
	void aplicarDesconto(int codigo, float percentual);
	void venderProdutos(int codigo, int quantidade);
}
