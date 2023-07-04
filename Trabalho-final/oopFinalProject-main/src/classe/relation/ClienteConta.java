package classe.relation;

import java.io.Serializable;
import classe.entities.accountModels.Conta;
import classe.entities.people.Cliente;

public class ClienteConta implements Serializable{

    Cliente cliente;//No caso de um cliente que possui mais de uma conta, instanciar mais uma posição no vetor repetindo o objeto cliente e trocando o objeto conta
    Conta conta;//No caso de uma conta que possui mais de uma cliente, instanciar mais uma posição no vetor repetindo o objeto conta e trocando o objeto cliente(Cuidado com a limitação de 2 clientes por conta)
    
    public ClienteConta(Cliente cliente, Conta conta) {
        this.cliente = cliente;
        this.conta = conta;
    }

    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString(){
		return getCliente().getNome() + " " + getConta().getNumConta()+ " " + getConta().getSenha();
	}
}