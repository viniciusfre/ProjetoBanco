package classe.relation;
import classe.entities.people.Gerente;
import classe.entities.bank.Agencia;
import java.io.Serializable;
public class GerenteAgencia implements Serializable{
    Gerente gerente;
    Agencia agencia;

    public GerenteAgencia(Gerente gerente, Agencia agencia){
        this.gerente = gerente;
        this.agencia = agencia;

    }

  public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	@Override
	public String toString(){
		return getGerente().getNome();
	}
}
