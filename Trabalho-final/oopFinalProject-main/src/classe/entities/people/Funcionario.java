package classe.entities.people;

import java.time.LocalDate;

import classe.util.Endereco;

public class Funcionario extends Pessoa {

	protected int numCartTrab;
	protected String rg;
	protected String sexo;
	protected String cargo;
	protected double salario = 1350;
	protected LocalDate dtIngresso;
	
	public Funcionario(String nome, String cpf, LocalDate dtNasc, String estadoCivil, Endereco endereco, int numCartTrab,
			String rg, String sexo, String cargo, double salario, LocalDate dtIngresso) {
		super(nome, cpf, dtNasc, estadoCivil, endereco);
		this.numCartTrab = numCartTrab;
		this.rg = rg;
		this.sexo = sexo;
		this.cargo = cargo;
		this.salario = salario;
		this.dtIngresso = dtIngresso;
	}
	
	public int getNumCartTrab() {
		return numCartTrab;
	}



	public void setNumCartTrab(int numCartTrab) {
		this.numCartTrab = numCartTrab;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public LocalDate getDtIngresso() {
		return dtIngresso;
	}



	public void setDtIngresso(LocalDate dtIngresso) {
		this.dtIngresso = dtIngresso;
	}



	public void calcularSalario(){
		if(LocalDate.now().getYear()-(dtIngresso.getYear() + (dtIngresso.getMonthValue()/12) + (dtIngresso.getDayOfMonth()/365)) >= 15){
			setSalario(getSalario() + (salario * 0.10));//pega a data e verifica se possui 15 anos de empresa para ganhar os 10% a mais de salario
		}
		else{
			//salario padrão pré definido
		}
		
	}
	

	

}

