package ecommerce.model;

public class SuplementoHipercalorico extends Suplemento {
	
	private String sabor;
	
	public SuplementoHipercalorico(int codigo, String nome, String marca, int tipo, double preco, int quantidadeEmEstoque) {
		super(codigo, nome, marca, tipo, preco, quantidadeEmEstoque);
		this.sabor = "Natural";
	}
	
	public SuplementoHipercalorico(int codigo, String nome, String marca, int tipo, double preco, int quantidadeEmEstoque, String sabor) {
		super(codigo, nome, marca, tipo,  preco, quantidadeEmEstoque);
		this.sabor = sabor;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Sabor: " + sabor);
	}
}
