package ecommerce.model;

public class SuplementoProteico extends Suplemento {

	private String tipoProteina;
	private int carboidrato;
	
	public SuplementoProteico(int codigo, String nome, String marca, int tipo, double preco, int quantidadeEmEstoque, String tipoProteina) {
		super(codigo, nome, marca, tipo, preco, quantidadeEmEstoque);
		this.tipoProteina = tipoProteina;
		this.carboidrato = 10;
	}
	
	public SuplementoProteico(int codigo, String nome, String marca, int tipo, double preco, int quantidadeEmEstoque, String tipoProteina, int carboidrato) {
		super(codigo, nome, marca, tipo, preco, quantidadeEmEstoque);
		this.tipoProteina = tipoProteina;
		this.carboidrato = carboidrato;
	}

	public String getTipoProteina() {
		return tipoProteina;
	}

	public void setTipoProteina(String tipoProteina) {
		this.tipoProteina = tipoProteina;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tipo de proteína: " + tipoProteina);
		System.out.println("Quantidade de carboidrato: " + carboidrato + " gramas");
	}

}
