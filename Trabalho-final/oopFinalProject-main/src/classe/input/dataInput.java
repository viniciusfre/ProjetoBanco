package classe.input;
import java.util.Scanner;
import java.time.LocalDate;
import classe.util.*;
import classe.entities.people.*;
import java.time.format.DateTimeFormatter;
public class dataInput{
  
	public static Cliente dadosBasicos() {
		
		Scanner sc = new Scanner(System.in);
		String nome,cpf, dtNasc, estCivil, escolaridade, estado, cidade, bairro, rua, nro, cep;
 		System.out.println("Qual o seu nome?");
 		nome = sc.nextLine();
		System.out.println("Qual sua data de nascimento?(dd/mm/yyyy)");
		dtNasc = sc.nextLine();
		do{
			System.out.println("Informe seu CPF: ");
			cpf = sc.nextLine();
			System.out.print("\033\143");
		}while(Verificadores.isCPF(cpf) == false);
		System.out.println("Informe seu estado civil: ");
		estCivil = sc.nextLine();
		System.out.println("Informe seu nível de escolaridade: ");
		escolaridade = sc.nextLine();
		System.out.println("Informe seu Estado: ");
		estado = sc.nextLine();
		System.out.println("Informe sua cidade: ");
		cidade = sc.nextLine();
		System.out.println("Informe seu bairro: ");
		bairro = sc.nextLine();
		System.out.println("Informe o nome da rua: ");
		rua = sc.nextLine();
		System.out.println("Informe o número da casa: ");
		nro = sc.nextLine();
		do{
			System.out.println("Informe o CEP: (Digite apenas numeros)");
			cep = sc.nextLine();
			System.out.print("\033\143");
		}while(Verificadores.isCEP(cep) == false);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Endereco endereco = new Endereco(estado, cidade, bairro, rua, nro, cep);		
		Cliente cli = new Cliente(nome, cpf, LocalDate.parse(dtNasc,formatter), estCivil, endereco, escolaridade);
		return cli;
	}

}