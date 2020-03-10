package br.com.projetocasamento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaConvidados {
	
	private List<Convidados> listaConvidados = new ArrayList<Convidados>();
	Scanner scan = new Scanner(System.in);
	
	public ListaConvidados() {
	}
	
	public void add(Convidados convidados) {
		listaConvidados.add(convidados);
	}
	
	public Convidados gravarTxt() {
		// Cria arquivo
		File f = new File("listaConvidados.txt");
		try {
			
			// Cria caso não existir
			if(!f.exists()) {
				f.createNewFile();
			}
			
			// Ler no Arquivo
			FileWriter escreverArquivo = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(escreverArquivo);

			bw.write("=======Lista de Convidados========");
			bw.newLine();
			for(Convidados lista: listaConvidados) {
				bw.write("Nome: "+lista.getNome());
				bw.newLine();
				bw.write("CPF: "+lista.getCpf());
				bw.newLine();
				bw.write("Numero de Familiares: "+lista.getFamiliares());
				bw.newLine();
				bw.write("Mesa: "+lista.getMesa());
				bw.newLine();
				bw.write("===========================");
				bw.newLine();
			}
			bw.close();
				
		}catch(Exception e){
			e.fillInStackTrace();
		}
		return null;
	}
	
	public void listarConvidados() {
		File arquivo = new File("listaConvidados.txt");
		 try {
			 if(!arquivo.exists()) {
				 arquivo.createNewFile();
			 }
			  FileReader lerArquivo = new FileReader(arquivo);
			  BufferedReader bf = new BufferedReader(lerArquivo);
			  
			  while(bf.ready()) {
				  String linha = bf.readLine();
				  System.out.println(linha);
			  }  
			  
		 }catch(Exception e) {
			 e.fillInStackTrace();
		 }
		
	}

	public Convidados encontrar(String cpfEncontrar) {
		for (Convidados convidado : listaConvidados) {
			String cpfCorrente = convidado.getCpf();
			if (cpfCorrente.equals(cpfEncontrar))
				return convidado;
		}
		return null;
	}
	
	public Convidados encontrarConvidado(String nome){
		for(Convidados convidado : listaConvidados){
			String nomeConvidado = convidado.getNome();
			if(nomeConvidado.equals(nome)){
				return convidado;
			}
		}
		return null;
	}
	
	public List<Convidados> getListaConvidados() {
		return listaConvidados;
	}


}
