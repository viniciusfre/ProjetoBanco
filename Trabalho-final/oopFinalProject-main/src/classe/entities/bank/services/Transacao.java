package classe.entities.bank.services;

import java.time.LocalDate;

import classe.entities.accountModels.Conta;

public class Transacao {
	//Gravar em arquivo a data de realização de qualquer transação que for executada, valor e canal
	//Ver qual a melhor forma de pegar o canal, pedir ao usuário ? Valida por algo ? Talvez usar um número randomico por fins didaticos que é gerado quando o usuario usa qualquer transação e dependendo desse numero o canal ser definido.
	private Conta conta;
	private LocalDate data;
	private  String canal;	

	public Transacao (Conta conta, LocalDate data, String canal){
		this.conta = conta;
		this.data = data;
		this.canal = canal;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	public  String getCanal() {
		return canal;
	}

	public  void setCanal(String canal) {
		this.canal = canal;
	}

	public boolean verificaSenha(String senhaDigitada){
		if(!(conta.getSenha().equals(senhaDigitada))) {		
			return false;
		}		
		return true;
	}

	public boolean saque(double valor, String senha){
		try {		
			if(verificaSenha(senha)) {
				if(conta.getSaldoAtual() < valor) {
					return false;
				}else {
					conta.setSaldoAtual(conta.getSaldoAtual()-valor);
					conta.setDtUltMov(LocalDate.now());
					System.out.println("Saque de R$:" + valor +" efetuado.");
					return true;
				}			
			}else {
				System.out.println("Senha incorreta");
			}		
					
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao tentar sacar: " + e);
		}
		return false;
	}

	public boolean deposito(double valor, String senha){
		try {
			if(verificaSenha(senha)) {
				if(valor <= 0) {
					return false;
				}	
				else {
					conta.setSaldoAtual(conta.getSaldoAtual()+valor);
					return true;
				}			
			}
			else {
				System.out.println("Senha incorreta");
			}		
				
	 	}
		catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar depositar: " + e);
		}
		return false;
	}

	public double consultarSaldo(String senha){
		try {
			if(verificaSenha(senha)) {
				return conta.getSaldoAtual();	
			}
			else {
				System.out.println("Senha incorreta");
				return -1;
			}		
				
	 	}
		catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar consultar saldo: " + e);
		}
		return -1;
	}

	public boolean efetuarPagamento(double valor, String senha){
		try {
			if(verificaSenha(senha)) {
					if(conta.getSaldoAtual() < valor){
						return false;
					}
					else{
						conta.setSaldoAtual(conta.getSaldoAtual()-valor);
						return true;
					}
			}
			else {
				System.out.println("Senha incorreta");
				return false;
			}		
				
	 	}
		catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar efetuar pagamento: " + e);
		}
		return false;
		
	}
}




