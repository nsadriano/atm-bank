package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Banco {

	static String nome = "Banco";
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Conta> contas;
	
	public static void main(String[] args) {
		
		contas = new ArrayList<Conta>();
		menu();
		
	}
	
	public static void menu() {
		int opcao = 0;
		System.out.println("======================================");
		System.out.println("============= " + nome + " ==================");
		System.out.println("======================================");
		System.out.println("Selecione uma op??o no menu:");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Efetuar saque");
		System.out.println("3 - Efetuar deposito");
		System.out.println("4 - Efetuar transfer?ncia");
		System.out.println("5 - Listar contas");
		System.out.println("6 - Sair do sistema");
		
		try {
			opcao = Integer.parseInt(entrada.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Por favor, informar op??o v?lida.");
			System.out.println(e.getMessage());
			Utils.pausar(1);
			menu();
		}
		
		switch(opcao) {
		case 1:
			criarConta();
			break;
		case 2:
			efetuandoSaque();
			break;
		case 3:
			efetuandoDeposito();
			break;
		case 4:
			efetuandoTransferencia();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			Utils.pausar(2);
			System.out.println("At? logo!");
			System.exit(0);
			break;
		default:
			System.out.println("Op??o inv?lida.");
			Utils.pausar(2);
			menu();
			break;
		}
	}
	
	public static void criarConta() {
		System.out.println("Informe os dados da conta:");
		
		System.out.println("Nome: ");
		String nome = entrada.nextLine();
		
		System.out.println("E-mail: ");
		String email = entrada.nextLine();
		
		System.out.println("CPF: ");
		String cpf = entrada.nextLine();
		
		System.out.println("Data de nascimento: ");
		String data_nascimento = entrada.nextLine();
		
		Cliente cliente = new Cliente(nome, email, cpf, Utils.stringParaData(data_nascimento));
		Conta conta = new Conta(cliente);
		contas.add(conta);
		
		System.out.println("Conta adicionada com sucesso!");
		System.out.println();
		
		Utils.pausar(2);
		menu();
		
	}
	
	public static void efetuandoSaque() {
		System.out.println("Informe o n?mero da conta");
		int numero = entrada.nextInt();
		
		Conta conta = buscarContaPorNumero(numero);
		
		if(conta != null) {
			System.out.println("Informe o valor para o saque");
			Double valor = entrada.nextDouble();
			conta.sacar(valor);
		}else {
			System.out.println("N?o foi encontrada a conta n?mero: " + numero);
		}
		
		Utils.pausar(2);
		menu();
	}
	
	public static void efetuandoDeposito() {
		System.out.println("Informe o n?mero da conta");
		int numero = entrada.nextInt();
		
		Conta conta = buscarContaPorNumero(numero);
		
		if(conta != null) {
			System.out.println("Informe o valor para deposito");
			Double valor = entrada.nextDouble();
			conta.depositar(valor);
		}else {
			System.out.println("N?o foi encontrada a conta com n?mero: " + numero);
		}
		
		Utils.pausar(2);
		menu();
	}
	
	public static void efetuandoTransferencia() {
		System.out.println("Informe o n?mero da conta de origem");
		int numero_origem = entrada.nextInt();
		
		System.out.println("Informe o n?mero da conta de destino");
		int numero_dest = entrada.nextInt();
		
		Conta conta_orig = buscarContaPorNumero(numero_origem);
		Conta conta_dest = buscarContaPorNumero(numero_dest);
		
		if(conta_orig != null && conta_dest != null) {
			System.out.println("Informe o valor a ser transferido");
			Double valor = entrada.nextDouble();
			
			conta_orig.tranferir(conta_dest, valor);
		}else {
			System.out.println("Uma das contas informadas n?o foi encontrada.");
		}
	}
	
	public static void listarContas() {
		if(contas.size() > 0) {
			for(Conta conta : contas) {
				System.out.println(conta);
				System.out.println();
			}
		}else {
			System.out.println("Ainda n?o existem contas cadastradas.");
		}
		Utils.pausar(4);
		menu();
	}
	
	public static Conta buscarContaPorNumero(int numero) {
		Conta c = null;
		if(contas.size() > 0) {
			for(Conta conta : contas) {
				if(conta.getCodigo() == numero) {
					c = conta;
				}
			}
		}
		return c;
	}
	
}
