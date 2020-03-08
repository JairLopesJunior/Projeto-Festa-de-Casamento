package br.com.projetocasamento;

public class Convidados {

	private String nome;
	private int familiares;
	private int mesa;
	private String cpf;
	Presentes pres;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getFamiliares() {
		return familiares;
	}
	public void setFamiliares(int familiares) {
		this.familiares = familiares;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Presentes getPres() {
		return pres;
	}
	public void setPres(Presentes pres) {
		this.pres = pres;
	}
	
	
}
