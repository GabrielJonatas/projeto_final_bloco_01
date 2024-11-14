package ecommerce.model;

public abstract class Suplemento {
	private int codigo;
	private String nome;
	private String marca;
	private int tipo;
	private double preco;
	private int quantidadeEmEstoque;
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Suplemento(int codigo, String nome, String marca, int tipo, double preco, int quantidadeEmEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	public void visualizar() {

		String tipo = "";
		
		switch (this.tipo) {
		case 1 -> tipo = "Hipercalórico";
		case 2 -> tipo = "Protéico";
		default -> System.out.println("Não possuimos esse tipo de suplemento");
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do suplemento:");
		System.out.println("***********************************************************");
		System.out.println("Código: " + this.codigo);
		System.out.println("Nome: " + this.nome);
		System.out.println("Marca: " + this.marca);
		System.out.println("Tipo: " + tipo);
		System.out.println("Preço: " + this.getPreco());
		System.out.println("Quantidade em estoque: " + this.quantidadeEmEstoque);
		
	}
	
}
