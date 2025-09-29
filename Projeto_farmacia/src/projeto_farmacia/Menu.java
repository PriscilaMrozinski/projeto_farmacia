package projeto_farmacia;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_farmacia.controller.ProdutoController;
import projeto_farmacia.model.Produto;
import projeto_farmacia.util.Cores;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();
	
	public static void main(String[] args) {
		
		/*TESTES:
		
		//int codigo; String nome; int tipo; float preco;int quantidade;
		Produto p1 = new Produto(1, "DorFlex", 1, 5.8f, 200);
		
		//Visualizar:
		p1.visualizar();
		
		//Alterar quantidade e nome:
		p1.setQuantidade(150);
		p1.setNome("Neosadina");
		
		//excluir estoque:
		p1.excluir(160);
		p1.visualizar();
		
		p1.excluir(120);
		p1.visualizar();
		
		//Adicionar quantidade:
		p1.adicionar(240);
		p1.visualizar();
		
		//testar classe Medicamentos
		Medicamentos m1 = new Medicamentos(3, "Doril a dor sumiu", 1, 10.00f, 35, 1, "Paracetamol");
		m1.visualizar();
		
		//testar classe Cosmeticos:
		Cosmeticos c1 = new Cosmeticos(1, "Shampoo", 3, 25.50f, 20, 3, "Dove");
		c1.visualizar();
		*/

		int opcao;

		while (true) {
			
			System.out.println(Cores.TEXT_GRAY + Cores.ANSI_CYAN_BACKGROUND_BRIGHT);
			System.out.println("         Bem-vindo ao Portal da Pharma Saúde!	   	  	        	");
			System.out.println(" A fármacia que transforma o seu cuidado na nossa prioridade.			");
			System.out.println("**********************************************************************		");
			System.out.println("                                                   			  	");
			System.out.println("            1 - Cadastrar produtos                  				");
			System.out.println("            2 - Listar produtos		                 			");
			System.out.println("            3 - Buscar produtos 		            			");
			System.out.println("            4 - Atualizar produtos				   		");
			System.out.println("            5 - Excluir produtos                     				");
			System.out.println("            6 - Aplicar desconto                    				");
			System.out.println("            7 - Vender produtos                    				");
			System.out.println("****************************************************************		");
			System.out.println("Entre com a opção desejada:                					\n\n");
			
			System.out.println(Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 7");
				leia.nextLine();
			}
			
			if (opcao == 0) {
				System.out.println("\nMenu encerrado. Obrigado por acessar o Portal da Pharma Saúde!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Cadastrar Produtos\n");
					cadastrarProdutos();
					keyPress();
					break;
				case 2:
					System.out.println("Listar Produtos\n");
					produtoController.listarProdutos();
					keyPress();
					break;
				case 3:
					System.out.println("Buscar Produtos\n");
					buscarProduto();
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar Produtos\n\n");
					atualizarProduto();
					keyPress();
					break;
				case 5:
					System.out.println("Excluir Produto\n\n");
					excluirProduto();
					keyPress();
					break;
				case 6:
					System.out.println("Aplicar Desconto\n\n");
					aplicarDesconto();
					keyPress();
					break;
				case 7:
					System.out.println("Vender Produtos\n\n");
					venderProduto();
					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RESET + Cores.TEXT_PURPLE + "Opção Inválida!\n\n");
					keyPress();
					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Priscila Lins Mrozinski - priscila_alins@hotmail.com");
		System.out.println("github.com/PriscilaMrozinski");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione ENTER para continuar...");
		leia.nextLine();
	}
	
	/*private static void cadastrarProdutos() {
	    Produto produto = new Produto(produtoController.gerarCodigo(), "Doril", 1, 10.20f, 200);
	    produtoController.cadastrarProdutos(produto);
	    //int codigo, String nome, int tipo (1-Medicamentos, 2-Cosméticos), float preco, int quantidade
	    //Atenção!! produtoController.gerarCodigo() → CERTO p minusculos, porque produtoController é um objeto da classe.
	} 
	*/
	
	// Método para cadastrar produto
	private static void cadastrarProdutos() {
		System.out.print("Digite o nome do Produto: ");
		String nome = leia.nextLine();

		System.out.print("Digite o tipo do Produto (1-Medicamento | 2-Cosmético | 3-Produto Comum): ");
		int tipo = leia.nextInt();

		System.out.print("Digite o preço do Produto: ");
		float preco = leia.nextFloat();

		System.out.print("Digite a quantidade em estoque: ");
		int quantidade = leia.nextInt();
		leia.nextLine(); // Consumir o ENTER

		// Gerar código automaticamente
		int codigo = produtoController.gerarCodigo();
		Produto produto = new Produto(codigo, nome, tipo, preco, quantidade);
		produtoController.cadastrarProdutos(produto);

		System.out.println("\nProduto cadastrado com sucesso! Código: " + codigo);
	}
	
	private static void buscarProduto() {
		System.out.print("Digite o código do produto: ");
		int codigo = leia.nextInt();
		produtoController.buscarProdutos(codigo);
	}

	private static void atualizarProduto() {
		System.out.print("Digite o código do Produto que deseja atualizar: ");
		int codigo = leia.nextInt();
		leia.nextLine();

		System.out.print("Digite o novo nome do Produto: ");
		String nome = leia.nextLine();

		System.out.print("Digite o novo tipo do Produto (1-Medicamento | 2-Cosmético): ");
		int tipo = leia.nextInt();

		System.out.print("Digite o novo preço do Produto: ");
		float preco = leia.nextFloat();

		System.out.print("Digite a nova quantidade em estoque: ");
		int quantidade = leia.nextInt();
		leia.nextLine();

		Produto produto = new Produto(codigo, nome, tipo, preco, quantidade);
		produtoController.atualizarProdutos(produto);
	}
    
	private static void excluirProduto() {
		System.out.print("Digite o código do produto que deseja excluir: ");
		int codigo = leia.nextInt();
		produtoController.excluirProdutos(codigo);
	}

	private static void aplicarDesconto() {
		System.out.print("Digite o código do Produto para aplicar desconto: ");
		int codigo = leia.nextInt();

		System.out.print("Digite o percentual de desconto: ");
		float percentual = leia.nextFloat();
		leia.nextLine();

		// CORRIGIDO: Removido o segundo parâmetro (String nome)
		produtoController.aplicarDesconto(codigo, percentual);
	}

	private static void venderProduto() {
		System.out.print("Digite o código do Produto para venda: ");
		int codigo = leia.nextInt();

		System.out.print("Digite a quantidade a vender: ");
		int qtd = leia.nextInt();
		leia.nextLine();

		// CORRIGIDO: Removido o segundo parâmetro (String nome)
		produtoController.venderProdutos(codigo, qtd);
	}
}
