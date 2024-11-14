package ecommerce.repository;

import ecommerce.model.Suplemento;

public interface EcommerceRepository {
	
	// CRUD da Loja
	public void procurarPorCodigo(int numero);
	public void listasTodos();
	public void cadastrar(Suplemento suplemento);
	public void atualizar(Suplemento suplemento);
	public void deletar(int numero);
}