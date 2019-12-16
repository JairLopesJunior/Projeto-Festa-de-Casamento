package br.com.projetocasamento;

import java.util.Scanner;

public class App {
	static int opcao = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Convidados conv = new Convidados();
		EstoquePresentes estoque = new EstoquePresentes();
		
		do {
			
			System.out.println("\nFundo Imobiliario");	
			System.out.println("==================================");	
			System.out.println("1.\t Realizar Cadastro");	
			System.out.println("**********************************");
			System.out.println("2.\t Editar Cadastro ");
			System.out.println("**********************************");
			System.out.println("3.\t Listar Cadastro ");
			System.out.println("**********************************");
			System.out.println("4.\t Ver Presentes ");
			System.out.println("**********************************");
			System.out.println("0.\t Encerrar sistema");	
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				System.out.println("Informe o seu nome? ");
				String nome = scan.next();
				conv.setNome(nome);
				System.out.println("Informe quantas pessoas da sua famlia vai participar? ");
				int numeroFamilia = scan.nextInt();
				conv.setFamiliares(numeroFamilia);
				System.out.println("Informe o numero da sua mesa? ");
				int mesa = scan.nextInt();
				conv.setMesa(mesa);
				System.out.println("Informe qual tipo de presente? ");
				String presente = scan.next();
				estoque.setTipo(presente);
				System.out.println("Informe o local comprado? ");
				String localCompra = scan.next();
				estoque.setLocalCompra(localCompra);
			}
			if(opcao == 2) {
				System.out.println("Informe o seu nome?");
				String nome = scan.next();
				conv.setNome(nome);
				System.out.println("Informe o numero da sua mesa?");
				int mesa = scan.nextInt();
				conv.setMesa(mesa);
			}
			if(opcao == 3) {
				System.out.println("Nome: " + conv.getNome());
				System.out.println("Quantidade de familiar: " + conv.getFamiliares());
				System.out.println("Mesa: " + conv.getMesa());
			}
			if(opcao == 4) {
				System.out.println("");
			}
			
			
		} while(opcao != 0);{
			System.out.println("****************************************");
			System.out.println("\t Casamento");
			System.out.println("****************************************");
		}

	}

}
