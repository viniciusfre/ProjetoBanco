package classe.entities.accountModels;

import java.time.LocalDate;

import classe.entities.bank.Agencia;

public class CSalario extends Conta{

	private double limiteSaque  = 2.000;
	private double limiteTransf = 4.000;

	public CSalario(int numConta, double saldoAtual, LocalDate dtAbertura,int status,
			boolean conjunta, Agencia agenciaAssociada,String senha) {
		super(numConta, saldoAtual, dtAbertura,null, status, conjunta, agenciaAssociada,senha);
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public double getLimiteTransf() {
		return limiteTransf;
	}

	public void setLimiteTransf(double limiteTransf) {
		this.limiteTransf = limiteTransf;
	}

}

