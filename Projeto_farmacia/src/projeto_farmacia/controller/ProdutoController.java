package projeto_farmacia.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_farmacia.model.Produto;

public class ProdutoController implements ProdutoRepository {
    private List<Produto> listaProdutos = new ArrayList<>();
    private int codigo = 0;

    @Override
    public void cadastrarProdutos(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto produto : listaProdutos) {
            produto.visualizar();
        }
    }

    @Override
    public void buscarProdutos(int codigo) {
        Produto produto = buscarNaCollection(codigo);
        if (produto != null) {
            produto.visualizar();
        } else {
            System.out.println("\nProduto não encontrado!");
        }
    }

    @Override
    public void atualizarProdutos(Produto produto) {
        Produto buscarProduto = buscarNaCollection(produto.getCodigo());
        if (buscarProduto != null) {
            listaProdutos.set(listaProdutos.indexOf(buscarProduto), produto);
            System.out.printf("\nProduto %s (código %d) atualizado com sucesso!%n", produto.getNome(), produto.getCodigo());
        } else {
            System.out.printf("\nProduto %s (código %d) não encontrado!%n", produto.getNome(), produto.getCodigo());
        }
    }

    // CORRIGIDO: agora implementa a interface corretamente
    @Override
    public void excluirProdutos(int codigo) {
        Produto produto = buscarNaCollection(codigo);
        if (produto != null) {
            listaProdutos.remove(produto);
            System.out.printf("\nProduto %s (código %d) excluído com sucesso!%n", produto.getNome(), produto.getCodigo());
        } else {
            System.out.println("\nProduto não encontrado!");
        }
    }

    // CORRIGIDO
    @Override
    public void aplicarDesconto(int codigo, float percentual) {
        Produto produto = buscarNaCollection(codigo);
        if (produto != null) {
            produto.setPreco(produto.getPreco() - (produto.getPreco() * percentual / 100));
            System.out.printf("\nDesconto de %.2f%% aplicado! Novo preço: R$ %.2f%n", percentual, produto.getPreco());
        } else {
            System.out.println("\nProduto não encontrado!");
        }
    }

    // CORRIGIDO
    @Override
    public void venderProdutos(int codigo, int quantidade) {
        Produto produto = buscarNaCollection(codigo);
        if (produto != null) {
            if (produto.excluir(quantidade)) {
                System.out.printf("\nVenda realizada! Total: R$ %.2f%n", produto.getPreco() * quantidade);
            }
        } else {
            System.out.println("\nProduto não encontrado!");
        }
    }

    public int gerarCodigo() {
        return ++codigo;
    }

    // CORRIGIDO: versão simplificada para buscar por código apenas (como a interface exige)
    private Produto buscarNaCollection(int codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
}
