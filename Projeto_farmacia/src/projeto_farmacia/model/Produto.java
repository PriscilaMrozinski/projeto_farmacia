package projeto_farmacia.model;

public class Produto {
	
	private int codigo;	
	private String nome;
	private int tipo;
	private float preco;
	private int quantidade;
	
	
	//Método construtor de objetos:
	public Produto(int codigo, String nome, int tipo_produto, float preco, int quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	//Menu Source - Generate Constructor using Fields
	//Método construtor: responsável por receber os valores e atribuir ao respectivo atributo da Classe
	//GET-acessa conteúdo
	//SET-modifica
	
	//Implementando os Métodos GET e SET
	//Source - Generate Getters and Setters
		
	//this: indica que o valor recebido será atribuído ao atributo da da instância da Classe
	//this.atributo = paramêtro recebido
	
		public int getCodigo() {
			return codigo;
		}


		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		
		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public int getTipo() {
			return tipo;
		}


		public void setTipo(int tipo_produto) {
			this.tipo = tipo_produto;
		}


		public float getPreco() {
			return preco;
		}


		public void setPreco(float preco) {
			this.preco = preco;
		}


		public int getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		
		//Adicionando Métodos excluir, adicionar, visualizar
		
		public boolean excluir (int qtd) {
			if (this.quantidade<qtd) {
				System.out.println("\nEstoque insuficiente.");
				return false;
			}
			this.quantidade -= qtd; //abreviando isso: this.quantidade = this.quantidade - quantidade;
			return true;
		}
		
		public int adicionar(int qtd) {
		    this.quantidade += qtd; 
		    return this.quantidade;
		}
		
		
		public void visualizar() {
			String tipo = "";
			switch (this.tipo) {
			case 1 -> tipo = "Medicamentos";
			case 2 -> tipo = "Cosméticos";
			}
			
			System.out.println("\n\n************************");
			System.out.println("Dados do Produtos: ");
			System.out.println("Código do Produto: " + this.codigo);
			System.out.println("Nome do Produto: " + this.nome);
			System.out.println("Tipo de Produto: " + tipo);
			System.out.println("Preço: " + this.preco);
			System.out.println("Quantidade em estoque: " + this.quantidade);
		}
}
	
