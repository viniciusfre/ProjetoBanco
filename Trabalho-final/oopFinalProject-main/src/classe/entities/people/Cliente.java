package classe.entities.people;
import java.time.LocalDate;
import classe.util.Endereco;

public class Cliente extends Pessoa {

  private String escolaridade;

  public Cliente(String nome, String cpf, LocalDate dtNasc, String estadoCivil,
      Endereco endereco, String escolaridade) {

    super(nome, cpf, dtNasc, estadoCivil, endereco);
    this.escolaridade = escolaridade;
  }

  public String getEscolaridade() {
    return escolaridade;
  }

  public void setEscolaridade(String escolaridade) {
    this.escolaridade = escolaridade;
  }

}
