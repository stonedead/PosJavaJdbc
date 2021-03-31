package br.com.rod.model;

public class BeanUserFone {

	private String nome;
	private String email;
	private String tipo;
	private String numero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "BeanUserFone [nome=" + nome + ", email=" + email + ", tipo=" + tipo + ", numero=" + numero + "]";
	}

	
	
}
