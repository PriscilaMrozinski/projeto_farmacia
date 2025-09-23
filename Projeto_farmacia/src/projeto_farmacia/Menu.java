package projeto_farmacia;

import java.util.Scanner;

import projeto_farmacia.model.Produto;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		
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
		
		int opcao;

		while (true) {

			System.out.println("*************************************************************");
			System.out.println("         Bem-vindo ao Portal da Pharma Saúde!	   	  	     ");
			System.out.println(" A fármacia que transforma o seu cuidado na nossa prioridade.");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar produto                    ");
			System.out.println("            2 - Editar produto 		                 ");
			System.out.println("            3 - Excluir produto 		             ");
			System.out.println("            4 - Listar produtos				         ");
			System.out.println("            5 - Buscar produto                       ");
			System.out.println("            6 - Adicionar estoque                    ");
			System.out.println("            7 - Excluir estoque                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nMenu encerrado. Obrigada por acessar nosso portal!");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Cadastrar produto\n\n");

					break;
				case 2:
					System.out.println("Editar produto\n\n");

					break;
				case 3:
					System.out.println("Excluir produto\n\n");

					break;
				case 4:
					System.out.println("Listar produtos\n\n");

					break;
				case 5:
					System.out.println("Buscar produto\n\n");

					break;
				case 6:
					System.out.println("Adicionar estoque\n\n");

					break;
				case 7:
					System.out.println("Excluir estoque\n\n");

					break;
				default:
					System.out.println("\nOpção Inválida!\n");
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
}
