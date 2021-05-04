package model;

public class Conta {
	
	private static int contador = 1001;
	
	private int codigo;
	private Cliente cliente;
	private Double saldo = 0.00;
	private Double limite = 0.00;
	private Double saldoTotal = 0.00;
	
	public Conta() {
		
	}

	public Conta(Cliente cliente) {
		super();
		codigo = Conta.contador;
		this.cliente = cliente;
		Conta.contador =+ 1;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimite() {
		return limite;
	}
	
	public void setLimite(Double limite) {
		this.limite = limite;
		atualizaSaldo();
	}

	public Double getSaldoTotal() {
		return saldoTotal;
	}

	@Override
	public String toString() {
		return "N�mero da conta: " + codigo + "\nCliente: \n" + cliente + "\nSaldo: " + saldo + "\nLimite=" + limite + "\nSaldo Total=" + saldoTotal;
	}
	
	public void atualizaSaldo() {
		saldoTotal = saldo + limite;
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && saldoTotal >= valor) {
			if(saldo >= valor) {
				saldo = saldo - valor;
				atualizaSaldo();
				System.out.println("Saque efetuado com sucesso!");
			}else {
				Double restante = saldo - valor;
				saldo = 0.00;
				atualizaSaldo();
				limite = limite + restante;
				System.out.println("Saque efetuado com sucesso!");
			}
		}else {
			System.out.println("Erro ao efetuar saque. Tente novamente");
		}
	}
	
	public void tranferir(Conta destino, Double valor) {
		if(valor > 0 && saldoTotal >= valor) {
			if(saldo >= valor) {
				saldo = saldo - valor;
				destino.saldo = destino.saldo + valor;
				atualizaSaldo();
				destino.atualizaSaldo();
				System.out.println("Transferencia realizada com sucesso!");
			}else {
				Double restante = saldo - valor;
				limite = limite - restante;
				saldo = 0.00;
				destino.saldo = destino.saldo + valor;
				atualizaSaldo();
				destino.atualizaSaldo();
				System.out.println("Transferencia realizada com sucesso!");
			}
		}else {
			System.out.println("Transferência não realizada. Tente novamente");
		}
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			saldo = saldo + valor;
			atualizaSaldo();
		}else {
			System.out.println("Erro ao efetuar deposito. Tente novamente");
		}
	}
	
}
