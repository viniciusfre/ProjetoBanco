package classe.entities.people;

import java.time.LocalDate;

import classe.util.Endereco;
import java.io.Serializable;
public abstract class Pessoa implements Serializable {	
	protected String nome;
	protected String cpf;
	protected LocalDate dtNasc;
	protected String estadoCivil;//Casado,Separado,Viúvo,Relação estável etc.
	protected Endereco endereco;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, LocalDate dtNasc, String estadoCivil, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
	
}


