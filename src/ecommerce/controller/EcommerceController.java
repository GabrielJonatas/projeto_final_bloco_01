package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Suplemento;
import ecommerce.repository.EcommerceRepository;

public class EcommerceController implements EcommerceRepository {

	private ArrayList<Suplemento> suplementos = new ArrayList<>();
	private ArrayList<String> logs = new ArrayList<String>();
	
	int codigo = 0;
	
	@Override
	public void procurarPorCodigo(int codigo) {
		var suplemento = buscarNaCollection(codigo);
		
		if(suplemento != null) 
			suplemento.visualizar(); 
		else
			System.out.println("\nO suplemento de código: " + codigo + " não foi encontrado!");
	}

	@Override
	public void listasTodos() {
		suplementos.forEach((var suplemento) -> suplemento.visualizar());
	}

	@Override
	public void cadastrar(Suplemento suplemento) {
		try {
			suplementos.add(suplemento);
			System.out.println("\nO suplemento número: " + suplemento.getCodigo() + " foi inserido com sucesso!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro muito estranho monstro! Vamos chamar os nerds para resolver");
			logs.add(e.getMessage());
		}
	}

	@Override
	public void atualizar(Suplemento suplemento) {
		var buscaSuplemento = buscarNaCollection(suplemento.getCodigo());
		
		if(buscaSuplemento != null) {
			try {
				suplementos.set(suplementos.indexOf(buscaSuplemento), suplemento);
				System.out.println("\nO suplemento de código: " + suplemento.getCodigo() + " foi atualizada com sucesso!");				
			} catch (Exception e) {
				System.out.println("Ocorreu um erro muito estranho monstro! Vamos chamar os nerds para resolver");
				logs.add(e.getMessage());
			}
		} else 
			System.out.println("\nO suplemento de código: " + suplemento.getCodigo() + " não foi encontrado!");
	}

	@Override
	public void deletar(int codigo) {
		var suplemento = buscarNaCollection(codigo);
		
		if (suplemento != null) {
			try {
				if (suplementos.remove(suplemento)) {
					System.out.println("\nO suplemento de código: " + codigo + " foi deletado com sucesso!");		
				}
			} catch (Exception e) {
				System.out.println("Ocorreu um erro muito estranho monstro! Vamos chamar os nerds para resolver");
				logs.add(e.getMessage());
			}
		} else
			System.out.println("\nO suplemento de código: " + codigo + " não foi encontrado!");
	}

	public int gerarCodigo() {
		return ++ codigo;
	}
	
	public Suplemento buscarNaCollection(int codigo) {
		for(var suplemento: suplementos) {
			if (suplemento.getCodigo() == codigo) {
				return suplemento;
			}
		}
		
		return null;
	}	
	
}
