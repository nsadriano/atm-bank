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
		System.out.println("Selecione uma opção no menu:");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Efetuar saque");
		System.out.println("3 - Efetuar deposito");
		System.out.println("4 - Efetuar transferência");
		System.out.println("5 - Listar contas");
		System.out.println("6 - Sair do sistema");
		
		try {
			opcao = Integer.parseInt(entrada.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Por favor, informar opção válida.");
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
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida.");
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
		System.out.println("Efetuando saque...");
	}
	
	public static void efetuandoDeposito() {
		System.out.println("Efetuando deposito...");
	}
	
	public static void efetuandoTransferencia() {
		System.out.println("Efetuando transferencia...");
	}
	
	public static void listarContas() {
		if(contas.size() > 0) {
			for(Conta conta : contas) {
				System.out.println(conta);
				System.out.println();
			}
		}else {
			System.out.println("Ainda não existem contas cadastradas.");
		}
		Utils.pausar(4);
		menu();
	}
	
}
