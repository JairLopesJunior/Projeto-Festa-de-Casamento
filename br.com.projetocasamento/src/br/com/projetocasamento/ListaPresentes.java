package br.com.projetocasamento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ListaPresentes {
	
	private List<Presentes> listaPresentes = new ArrayList<Presentes>(); 

	public ListaPresentes() {}

	public void add(Presentes presentes) {
		listaPresentes.add(presentes);
	}
	
	File l = new File("Presentes.txt");
	
	public Presentes gravarPresentes() {
		try {
			
			if(!l.exists()) {
				l.createNewFile();
			}
			
			FileWriter fw = new FileWriter(l.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("=======Lista de Presentes========");
			bw.newLine();
			for(Presentes p: listaPresentes) {
				bw.write("Tipo: " + p.getTipo());
				bw.newLine();
				bw.write("Local de Compra: " + p.getLocalCompra());
				bw.newLine();
				bw.write("===========================");
				bw.newLine();
			}
			bw.close();
			
		}catch(Exception e) {
			e.fillInStackTrace();
		}
		return null;
	}
	
	public void lerPresentes() {
		try {
			FileReader fr = new FileReader(l);
			BufferedReader bf = new BufferedReader(fr);
			
			while(bf.ready()) {
				String s = bf.readLine();
				System.out.println(s);
			}
			
		}catch(Exception e) {
			
		}
	}

	public List<Presentes> getListaPresentes() {
		return listaPresentes;
	}
	
}
