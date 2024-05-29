package model;

public class Cliente {
	private String nome;
	private String cpf;
	private String numero;
	private String email;
	private String endereco;
	
	public Cliente(String nome, String cpf, String numero, String Email, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		this.email = email;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", documento=" + cpf + ", numero="+ numero + "email="+ email+ ", endereço="+ endereco + "]";
	}
		
}
