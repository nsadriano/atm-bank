package model;

import java.util.Date;

import helper.Utils;

public class Cliente {
	
	private static int contador = 101;
	
	private int codigo;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private Date dataCadastro;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String email, String cpf, Date dataNascimento) {
		super();
		this.codigo = Cliente.contador;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = new Date();
		Cliente.contador = contador + 1;
	}
	
	public int getCodigo() {
		return codigo;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Codigo do cliente: " + codigo +
				"\nNome do Cliente: " + nome + 
				"\nE-mail: " + email +
				"\nData de nascimento: " + Utils.dateParaString(dataNascimento) +
				"\nData de cadastro: " + Utils.dateParaString(dataCadastro);
		}

}
