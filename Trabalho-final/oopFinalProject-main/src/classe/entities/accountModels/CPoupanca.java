package classe.entities.accountModels;

import java.time.LocalDate;

import classe.entities.bank.Agencia;

public class CPoupanca extends Conta {

	private double rendimentoMes;

	

	public CPoupanca(int numConta, double saldoAtual, LocalDate dtAbertura,int status,
			boolean conjunta, Agencia agenciaAssociada,String senha, double rendimentoMes) {
		super(numConta, saldoAtual, dtAbertura,null, status, conjunta, agenciaAssociada, senha);
		this.rendimentoMes = rendimentoMes;
	}

	public double getRendimentoMes() {
		return rendimentoMes;
	}



	public void setRendimentoMes(double rendimentoMes) {
		this.rendimentoMes = rendimentoMes;
	}

	@Override
	public String toString() {		
		return  "---------------------------------------"      
			  + "\nN� Conta: " 					+ numConta
			  + "\nAg�ncia: " 					+ getAgenciaAssociada().getNomeAgencia()
			  //+ "\nTitular: " 					+ getClienteAssociado().getNome() -> resolver
			  + "\nSaldo atual: " 				+ saldoAtual
			  + "\nData abertura: " 		  	+ dtAbertura
			  + "\nData �ltima movimenta��o: "	+ dtUltMov 
			  + "\nStatus da conta: " 			+ status
			  + "\nRendimento do m�s atual: "	+ rendimentoMes
			  + "\n---------------------------------------";			  
	}

}
