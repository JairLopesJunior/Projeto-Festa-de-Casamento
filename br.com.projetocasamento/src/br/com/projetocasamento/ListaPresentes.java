package br.com.projetocasamento;

import java.util.ArrayList;
import java.util.List;

public class ListaPresentes {
	
	private List<Presentes> listaPresentes = new ArrayList<>(); 
	
	public void add(Presentes convidados) {
		listaPresentes.add(convidados);
	}
}
