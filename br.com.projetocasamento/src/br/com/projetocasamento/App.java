package br.com.projetocasamento;

import java.util.Scanner;

public class App {
	static int opcao = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Convidados conv = new Convidados();
		ListaConvidados lista = new ListaConvidados();
		ListaPresentes listaPresentes = new ListaPresentes();
		Presentes presentes = new Presentes();
		
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
			System.out.println("5.\t Ver Convidados ");
			System.out.println("**********************************");
			System.out.println("0.\t Encerrar sistema");	
			opcao = scan.nextInt();
			
				if(opcao == 1) {
					
					try {
						Convidados convi = new Convidados();
						System.out.println("Informe o seu nome? ");
						String nome = scan.next();
						convi.setNome(nome);
						System.out.println("Informe o seu CPF? ");
						String cpf = scan.next();
						convi.setCpf(cpf);
						System.out.println("Informe quantas pessoas da sua famlia vai participar? ");
						int numeroFamilia = scan.nextInt();
						conv.setFamiliares(numeroFamilia);
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
							System.out.println("Tipo de Presente: " + presentes.getTipo());
							System.out.println("Local de Compra: " + presentes.getLocalCompra());
						}
					}catch(Exception e){
						System.out.println(e.fillInStackTrace());
					}	
				} 
				if(opcao == 5) {
					lista.gravarTxt();
				}
			
		}	while(opcao != 0);
		{
			System.out.println("****************************************");
			System.out.println("\t Casamento");
			System.out.println("****************************************");
		}
	}
}
