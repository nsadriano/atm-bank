package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Teste {

	public static void main(String[] args) {

		Cliente c1 = new Cliente(
				"Adriano Nascimento",
				"ns.adriano@gmail.com",
				"829.400.023-04",
				Utils.stringParaData("28/03/1980"));
		
		Cliente c2 = new Cliente(
				"Derick Luanderson",
				"derick@gmail.com",
				"123.456.789-01",
				Utils.stringParaData("02/06/2003"));
		
		//System.out.println(c1);
		//System.out.println();
		//System.out.println(c2);
		
		//Realizar deposito
		Conta conta1 = new Conta(c1);
		Conta conta2 = new Conta(c2);
		
		conta1.depositar(500.00);
		conta1.setLimite(200.00);
		//conta1.depositar(100.00);
		
		//System.out.println(conta1);
		//System.out.println();
		//System.out.println(conta2);
		
		//Realizar saque
		conta1.sacar(100.00);
		
		conta1.tranferir(conta2, 100.00);
		
		conta2.setLimite(50.00);
		
		System.out.println(conta1);
		System.out.println();
		System.out.println(conta2);
	}

}
