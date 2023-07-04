package classe.entities.accountModels;

import java.time.LocalDate;
import java.io.Serializable;
import classe.entities.bank.Agencia;
//import classe.relation.ClienteConta;

public abstract class Conta implements Serializable{
	//relacionar cliente e conta
	protected  int numConta;
	protected  double saldoAtual;
	protected  LocalDate dtAbertura;
	protected  LocalDate dtUltMov;
	protected  int status;//1 ativa 0 inativa
	protected  boolean conjunta;
	protected  Agencia agenciaAssociada;
	protected String senha;
	
	public Conta(int numConta, double saldoAtual, LocalDate dtAbertura, LocalDate dtUltMov, int status,
			boolean conjunta, Agencia agenciaAssociada,String senha) {
		this.numConta = numConta;
		this.saldoAtual = saldoAtual;
		this.dtAbertura = dtAbertura;
		this.dtUltMov = dtUltMov;
		this.status = status;
		this.conjunta = conjunta;
		this.agenciaAssociada = agenciaAssociada;
		this.senha = senha;

		//return ClienteConta clienteConta = new ClienteConta(clienteAssociado,this);
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public LocalDate getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(LocalDate dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public LocalDate getDtUltMov() {
		return dtUltMov;
	}

	public void setDtUltMov(LocalDate dtUltMov) {
		this.dtUltMov = dtUltMov;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isConjunta() {
		return conjunta;
	}

	public void setConjunta(boolean conjunta) {
		this.conjunta = conjunta;
	}

	public Agencia getAgenciaAssociada() {
		return agenciaAssociada;
	}

	public void setAgenciaAssociada(Agencia agenciaAssociada) {
		this.agenciaAssociada = agenciaAssociada;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	
}
