package classe.entities.bank;

import classe.util.Endereco;
import java.io.Serializable;
public class Agencia implements Serializable {

	private int numeroAgencia;
	private String nomeAgencia;
	private Endereco endereco;

    public Agencia(int numeroAgencia, String nomeAgencia,Endereco endereco) {
        this.numeroAgencia = numeroAgencia;
        this.nomeAgencia = nomeAgencia;
        this.endereco = endereco;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
		
   
}
