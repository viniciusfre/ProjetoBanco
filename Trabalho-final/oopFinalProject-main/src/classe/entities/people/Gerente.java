package classe.entities.people;

import java.time.LocalDate;
import classe.util.Endereco;

public class Gerente extends Funcionario {
	
	private LocalDate dtIngressoCarreira;
	private boolean possuiFormacao;
	private static double comissao = 10000;
	
	public Gerente(String nome, String cpf, LocalDate dtNasc, String estadoCivil, Endereco endereco, int numCartTrab,
			String rg, String sexo, String cargo, double salario, LocalDate dtIngresso, LocalDate dtIngressoCarreira,
			boolean possuiFormacao) {
		super(nome, cpf, dtNasc, estadoCivil, endereco, numCartTrab, rg, sexo, cargo, salario, dtIngresso);
		this.dtIngressoCarreira = dtIngressoCarreira;
		this.possuiFormacao = possuiFormacao;
	}

	public LocalDate getDtIngressoCarreira() {
		return dtIngressoCarreira;
	}

	public void setDtIngressoCarreira(LocalDate dtIngressoCarreira) {
		this.dtIngressoCarreira = dtIngressoCarreira;
	}

	public boolean isPossuiFormacao() {
		return possuiFormacao;
	}

	public void setPossuiFormacao(boolean possuiFormacao) {
		this.possuiFormacao = possuiFormacao;
	}

	public static double getComissao() {
		return comissao;
	}

	public static void setComissao(double comissao) {
		Gerente.comissao = comissao;
	}
	
	@Override
	public void calcularSalario(){
		super.setSalario(super.getSalario() + comissao);//salario de gerente, salario comum + comissao
		
	}
	
	
}
