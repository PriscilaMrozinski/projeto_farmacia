package projeto_farmacia.model;

public class Cosmeticos extends Produto{
	//Atributos específico:
	private int tipo_uso;
	private String marca;
	
	
	//Método Construtor:	
	public Cosmeticos(int codigo, String nome, int tipo_produto, float preco, int quantidade, int tipo_uso,
			String marca) {
		super(codigo, nome, tipo_produto, preco, quantidade);
		this.tipo_uso = tipo_uso;
		this.marca = marca;
	}

	//Métodos Get e Set:
	public int getTipo_uso() {
		return tipo_uso;
	}

	public void setTipo_uso(int tipo_uso) {
		this.tipo_uso = tipo_uso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	//Adiciona por Herança o método visualizar:
	@Override
	public void visualizar() {	
		String uso ="";
		switch(this.tipo_uso) {
		case 1 -> uso="facial";
		case 2 -> uso="corporal";
		case 3 -> uso="capilar";
		default -> uso="sem tarja";
		}
		
		
		super.visualizar();
		System.out.printf("Tipo de Uso: %s%n", uso);
		System.out.printf("Marca: %s%n", this.marca);
		
	}
	
	

}
