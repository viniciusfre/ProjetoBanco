package classe.entities.accountModels;
import java.time.LocalDate;

import classe.entities.bank.Agencia;
//import java.time.format.DateTimeFormatter;
public class CCorrente extends Conta {

	private double limiteCheque=500;
	private double valorTaxaAdm=50;
	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//LocalDate ld = LocalDate.parse("01/01/1800",formatter);
	public CCorrente(int numConta, double saldoAtual, LocalDate dtAbertura, int status,
			boolean conjunta, Agencia agenciaAssociada,String senha) {
		super(numConta, saldoAtual, dtAbertura,null, status, conjunta, agenciaAssociada, senha);
	}

	public double getLimiteCheque() {
		return limiteCheque;
	}

	public void setLimiteCheque(double limiteCheque) {
		this.limiteCheque = limiteCheque;
	}

	public double getValorTaxaAdm() {
		return valorTaxaAdm;
	}

	public void setValorTaxaAdm(double valorTaxaAdm) {
		this.valorTaxaAdm = valorTaxaAdm;
	}

}
