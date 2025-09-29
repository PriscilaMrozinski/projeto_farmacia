package projeto_farmacia.model;

public class Cosmeticos extends Produto{
	//Atributos específicos:
	private int tipoUso;
	private String marca;
		
	//Método Construtor:	
	public Cosmeticos(int codigo, String nome, int tipo, float preco, int quantidade, int tipoUso, String marca) {
		super(codigo, nome, tipo, preco, quantidade);
		this.tipoUso = tipoUso;
		this.marca = marca;
	}

	//Métodos Get e Set:
	public int getTipoUso() {
		return tipoUso;
	}

	public void setTipoUso(int tipoUso) {
		this.tipoUso = tipoUso;
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
		switch(this.tipoUso) {
		case 1 -> uso="facial";
		case 2 -> uso="corporal";
		case 3 -> uso="capilar";
		default -> uso="sem tipo de uso";
		}
		
	
		super.visualizar();
		System.out.printf("Tipo de Uso: %s%n", uso);
		System.out.printf("Marca: %s%n", this.marca);
		
	}

}
