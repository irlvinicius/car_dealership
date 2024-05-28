package model;

public class Cliente {
	private String nome;
	private String cpf;
	private String numero;
	private String endereco;
	
	public Cliente(String nome, String cpf, String numero, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", documento=" + cpf + ", numero="+ numero + ", endereço="+ endereco + "]";
	}
		
}
