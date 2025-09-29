package projeto_farmacia.model;

public class Medicamentos extends Produto {
	
	private int tarja;
	private String principioAtivo;
	
	//Método Construtor:
	public Medicamentos(int codigo, String nome, int tipo, float preco, int quantidade, int tarja,
			String principioAtivo) {
		super(codigo, nome, tipo, preco, quantidade);
		this.tarja = tarja;
		this.principioAtivo = principioAtivo;
	}
	
	//Implementa Get e Set para os novos atributos específicos:

	public int getTarja() {
		return tarja;
	}

	public void setTarja(int tarja) {
		this.tarja = tarja;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}


	//Adiciona por Herança o método visualizar:
	@Override
	public void visualizar() {	
		String cortarja ="";
		switch(this.tarja) {
		case 1 -> cortarja="preta";
		case 2 -> cortarja="vermelha";
		case 3 -> cortarja="amarela";
		default -> cortarja="sem tarja";
		}
		
		super.visualizar();
		System.out.printf("Tipo de Tarja: %s%n", cortarja);
		System.out.printf("Princípio ativo: %s%n", this.principioAtivo);
		
	}
	
}
