package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		int opcao;

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
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "\nMonster Factory - Saia da jaula também monstro!!");
				sobre();
                leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1 -> System.out.println(Cores.TEXT_WHITE + "Cadastrar suplemento \n\n");
				case 2 -> System.out.println(Cores.TEXT_WHITE + "Listar todos os suplementos da loja\n\n");
				case 3 -> System.out.println(Cores.TEXT_WHITE + "Buscar suplemento por código  \n\n");
				case 4 -> System.out.println(Cores.TEXT_WHITE + "Atualizar dados de um suplemento\n\n");
				case 5 -> System.out.println(Cores.TEXT_WHITE + "Apagar suplemento \n\n");
				default -> System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
			}
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