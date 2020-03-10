package br.com.projetocasamento;

import java.util.Scanner;

public class App {
	static int opcao = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ListaConvidados lista = new ListaConvidados();
		ListaPresentes listaPresentes = new ListaPresentes();
		int cont = 0;
		int cont2 = 0;
		
		do {
			
			System.out.println("\nCadastro de Casamento");	
			System.out.println("==================================");	
			System.out.println("1.\t Realizar Cadastro");	
			System.out.println("**********************************");
			System.out.println("2.\t Editar Cadastro ");
			System.out.println("**********************************");
			System.out.println("3.\t Listar Cadastro ");
			System.out.println("**********************************");
			System.out.println("4.\t Ver Presentes ");
			System.out.println("**********************************");
			System.out.println("5.\t Gravar Convidados em TXT ");
			System.out.println("**********************************");
			System.out.println("6.\t Ler Convidados do TXT ");
			System.out.println("**********************************");
			System.out.println("7.\t Gravar Presenes no TXT ");
			System.out.println("**********************************");
			System.out.println("8.\t Ler Presenes do TXT ");
			System.out.println("**********************************");
			System.out.println("0.\t Encerrar sistema");	
			opcao = scan.nextInt();
			
				if(opcao == 1) {
					
					try {
						Convidados convi = new Convidados();
						Presentes presentes = new Presentes();
						Padrinhos p = new Padrinhos();
						System.out.println("Informe o seu nome? ");
						String nome = scan.next();
						convi.setNome(nome);
						System.out.println("Você é padrinho?(S) ou (N)");
						String padrinho = scan.next();
						if(padrinho.equalsIgnoreCase("s")) {
							System.out.println("É padrinho do noivo?(S) ou (N)");
							String pad = scan.next();
							if(pad.equalsIgnoreCase("s")) {
								if(cont >= 4) {
									System.out.println("Numero limite de Padrinhos esgotados");
									System.exit(0);
								}else {
									p.setPadrinhoNoivo(pad);
									cont++;
									System.out.println(cont);
								}
							}else {
								if(cont >= 4) {
									System.out.println("Numero limite de Padrinhos esgotados");	
									System.exit(0);
								}else {
									p.setPadrinhoNoiva(pad);
									cont2++;
								}
							}
						}
						System.out.println("Informe o seu CPF? ");
						String cpf = scan.next();
						convi.setCpf(cpf);
						System.out.println("Informe quantas pessoas da sua familia vai participar? ");
						int numeroFamilia = scan.nextInt();
						convi.setFamiliares(numeroFamilia);
						System.out.println("Informe o numero da sua mesa? ");
						int mesa = scan.nextInt();
						convi.setMesa(mesa);
						System.out.println("Informe qual tipo de presente? ");
						String presente = scan.next();
						presentes.setTipo(presente);
						System.out.println("Informe o local comprado? ");
						String localCompra = scan.next();
						presentes.setLocalCompra(localCompra);
						System.out.println();
						lista.add(convi);
						listaPresentes.add(presentes);
						System.out.println("==================================");
						System.out.println("Pessoa Cadastrada com sucesso");
						System.out.println("==================================");
					}catch(Exception e){
						System.out.println(e.fillInStackTrace());
						System.out.println(e.getMessage());
					}
				}
				
				if(opcao == 2) {
						System.out.println("Informe o seu CPF:");
						String cpfEncontrar = scan.next();
						Convidados convidadosEncontrados = lista.encontrar(cpfEncontrar);
						if(convidadosEncontrados != null){
							System.out.println("Informe o novo nome");
							String nomeNovo = scan.next();
							convidadosEncontrados.setNome(nomeNovo);
							System.out.println("Informe o numero da mesa");
							int mesaNova = scan.nextInt();
							convidadosEncontrados.setMesa(mesaNova);
							System.out.println("==================================");
							System.out.println("Dados editado com sucesso");
							System.out.println("==================================");
						}else {
							System.out.println("==================================");
							System.out.println("CPF Inválido");
							System.out.println("==================================");
						}
				}
				
				if(opcao == 3) {
					try {
						System.out.println("Informe o seu CPF:");
						String cpfEncontrar = scan.next();
						Convidados convidadosEncontrados = lista.encontrar(cpfEncontrar);
						if(convidadosEncontrados != null){
							System.out.println("Nome: " + convidadosEncontrados.getNome());
							System.out.println("Quantidade de familiar: " + convidadosEncontrados.getFamiliares());
							System.out.println("Mesa: " + convidadosEncontrados.getMesa());
						}else{
							throw new Exception("CPF Inválido");
						}
					}catch(Exception e){
						System.out.println(e.fillInStackTrace());
					}
				}
				
				if(opcao == 4) {
					try {
						System.out.println("Informe o nome do convidado");
						String nome = scan.next();
						Convidados convidadosEncontrados = lista.encontrarConvidado(nome);
						if(convidadosEncontrados != null){
							System.out.println("Nome: " + convidadosEncontrados.getNome());
							System.out.println("Tipo de Presente: " + convidadosEncontrados.getPres().getTipo());
							System.out.println("Local de Compra: " + convidadosEncontrados.getPres().getLocalCompra());
						}
					}catch(Exception e){
						System.out.println(e.fillInStackTrace());
					}	
				} 
				
				if(opcao == 5) {
					lista.gravarTxt();
				}
				
				if(opcao == 6) {
					lista.listarConvidados();
				}
				
				if(opcao == 7) {
					listaPresentes.gravarPresentes();
				}
				
				if(opcao == 8) {
					listaPresentes.lerPresentes();
				}
			
		}	while(opcao != 0);
		{
			System.out.println("****************************************");
			System.out.println("\t Casamento");
			System.out.println("****************************************");
		}
	}
}
