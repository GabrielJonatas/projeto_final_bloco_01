package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.model.SuplementoHipercalorico;
import ecommerce.model.SuplementoProteico;
import ecommerce.util.Cores;

public class Menu {
	public static void main(String[] args) {

		EcommerceController ecommerce = new EcommerceController();
		
		Scanner leia = new Scanner(System.in);
		int opcao;
		
		int codigo, tipo, quantidadeEmEstoque, carboidrato;
		double preco;
		String nome, marca, tipoProteina, sabor;
		char simOuNao;
		
		SuplementoHipercalorico hipercalorico1 = new SuplementoHipercalorico(
			    ecommerce.gerarCodigo(), "Hipercalórico Massa", "Good Shape", 1, 50.00, 50
			);
		ecommerce.cadastrar(hipercalorico1);
		
		SuplementoHipercalorico hipercalorico2 = new SuplementoHipercalorico(
				ecommerce.gerarCodigo(), "Hipercalórico Radical", "Grow Monster", 1, 80.00, 30, "Morango"
			);
		ecommerce.cadastrar(hipercalorico2);
		
		SuplementoProteico proteico1 = new SuplementoProteico(
				ecommerce.gerarCodigo(), "Proteína Vegana", "Caminho vegano", 2, 100.00, 40, "Proteína da Soja"
			);
		ecommerce.cadastrar(proteico1);

		SuplementoProteico proteico2 = new SuplementoProteico(
				ecommerce.gerarCodigo(), "Proteína do Leite", "Grow Monster", 2, 180.00, 20, "Whey", 0
			);
		ecommerce.cadastrar(proteico2);
		
		while (true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                MONSTER FACTORY                      ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar suplemento                 ");
			System.out.println("            2 - Listar todos os suplementos da loja  ");
			System.out.println("            3 - Buscar suplemento por código         ");
			System.out.println("            4 - Atualizar dados de um suplemento     ");
			System.out.println("            5 - Apagar suplemento                    ");
			System.out.println("            6 - Imprimir logs de erro do sistema     ");
			System.out.println("            7 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();	
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros monstro!");
				leia.nextLine();
				opcao = 0;
				keyPress();
			}

			if (opcao == 7) {
				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "\nMonster Factory - Saia da jaula também monstro!!");
				sobre();
                leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1 -> {
					System.out.println(Cores.TEXT_WHITE + "Cadastrar suplemento \n\n");
					
					System.out.println("Digite o nome do suplemento: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					System.out.println("Digite a marca: ");
					marca = leia.next();
						
					do {
						System.out.println("Digite o tipo de suplemento (1-hipercalórico ou 2-suplemento protéico): ");
						tipo = leia.nextInt();
					} while(tipo < 1 && tipo > 2);
						
					System.out.println("Digite o preço (R$): ");
					preco = leia.nextFloat();
						
					System.out.println("Digite a quantidade em estoque: ");
					quantidadeEmEstoque = leia.nextInt();
						
					switch(tipo) {
					case 1 -> {
						System.out.println("Tem sabor?");
						simOuNao = leia.next().charAt(0);
						if (simOuNao == 's') {
							System.out.println("Digite o sabor do suplemento: ");
							sabor = leia.next();	
							ecommerce.cadastrar(new SuplementoHipercalorico(ecommerce.gerarCodigo(), nome, marca, tipo, preco, quantidadeEmEstoque, sabor));		
						} else {
							ecommerce.cadastrar(new SuplementoHipercalorico(ecommerce.gerarCodigo(), nome, marca, tipo, preco, quantidadeEmEstoque));							
						}

					}
					case 2 -> {
						System.out.println("Digite o tipo de proteína: ");
						tipoProteina = leia.next();
						System.out.println("Tem carboidratos?");
						simOuNao = leia.next().charAt(0);
						if (simOuNao == 's') {
							System.out.println("Digite a quantidade de carboidratos em gramas: ");
							carboidrato = leia.nextInt();
							ecommerce.cadastrar(new SuplementoProteico(ecommerce.gerarCodigo(), nome, marca, tipo, preco, quantidadeEmEstoque, tipoProteina, carboidrato));	
						} else {
							ecommerce.cadastrar(new SuplementoProteico(ecommerce.gerarCodigo(), nome, marca, tipo, preco, quantidadeEmEstoque, tipoProteina));								
						}
						}
					}
					
					keyPress();
				}
				case 2 -> {
					System.out.println(Cores.TEXT_WHITE + "Listar todos os suplementos da loja\n\n");
					ecommerce.listasTodos();
					keyPress();
				}
				case 3 -> {
					System.out.println(Cores.TEXT_WHITE + "Buscar suplemento por código  \n\n");
					System.out.println("Digite o código do suplemento: ");
					codigo = leia.nextInt();
					
					ecommerce.procurarPorCodigo(codigo);
					
					keyPress();
				}
				case 4 -> {
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados de um suplemento\n\n");
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
					
					System.out.println("Digite o código do suplemento: ");
					codigo = leia.nextInt();
					
					var suplemento = ecommerce.buscarNaCollection(codigo);
					
					if(suplemento != null) {
						
						tipo = suplemento.getTipo();
						
						System.out.println("Digite o nome do suplemento: ");
						leia.skip("\\R?");
						nome = leia.nextLine();
						
						System.out.println("Digite a marca: ");
						marca = leia.next();
						
						System.out.println("Digite o preço (R$): ");
						preco = leia.nextFloat();
						
						System.out.println("Digite a quantidade em estoque: ");
						quantidadeEmEstoque = leia.nextInt();	
							
						switch(tipo) {
							case 1 -> {
								System.out.println("Tem sabor?");
								simOuNao = leia.next().charAt(0);
								if (simOuNao == 's') {
									System.out.println("Digite o sabor do suplemento: ");
									sabor = leia.next();	
									ecommerce.cadastrar(new SuplementoHipercalorico(codigo, nome, marca, tipo, preco, quantidadeEmEstoque, sabor));		
								} else {
									ecommerce.cadastrar(new SuplementoHipercalorico(codigo, nome, marca, tipo, preco, quantidadeEmEstoque));							
								}

							}
							case 2 -> {
								System.out.println("Digite o tipo de proteína: ");
								tipoProteina = leia.next();
								System.out.println("Tem carboidratos?");
								simOuNao = leia.next().charAt(0);
								if (simOuNao == 's') {
									System.out.println("Digite a quantidade de carboidratos em gramas: ");
									carboidrato = leia.nextInt();
									ecommerce.atualizar(new SuplementoProteico(codigo, nome, marca, tipo, preco, quantidadeEmEstoque, tipoProteina, carboidrato));	
								} else {
									ecommerce.atualizar(new SuplementoProteico(codigo, nome, marca, tipo, preco, quantidadeEmEstoque, tipoProteina));								
								}
							}
							default -> {
								System.out.println("Código inválido!");
							}
						}
						
					} else {
						System.out.println("O suplemento não foi encontrado!");
					}
					
					keyPress();
				}
				case 5 -> {
					System.out.println(Cores.TEXT_WHITE + "Apagar suplemento \n\n");
					
					System.out.println("Digite o código do suplemento: ");
					codigo = leia.nextInt();
					
					ecommerce.deletar(codigo);
					
					keyPress();
				}
				case 6 -> {
					System.out.println(Cores.TEXT_WHITE + "Imprimir logs de erro do sistema\n\n");
					
					ecommerce.logsSistema();
					
					keyPress();
				}
				default -> System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
			}
		}
	}
	
	public static void keyPress() {
		
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
			
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
    
	public static void sobre() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "*****************************************************");
		System.out.println("Projeto Desenvolvido por: Gabriel Jonatas");
		System.out.println("Generation Brasil - gabriels@generation.org");
		System.out.println("github.com/GabrielJonatas");
		System.out.println("*********************************************************");
	}
	
    


}