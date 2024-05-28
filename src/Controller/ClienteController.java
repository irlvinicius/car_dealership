package Controller;

import java.util.ArrayList;

import model.Cliente;

public class ClienteController {
	private ArrayList<Cliente> pessoas = new ArrayList<Cliente>();
	
	public void add(Cliente p) {
		this.pessoas.add(p);
	}
	
	public void listar() {
		for(Cliente p: this.pessoas) {
			System.out.println(p);
		}
	}
}
