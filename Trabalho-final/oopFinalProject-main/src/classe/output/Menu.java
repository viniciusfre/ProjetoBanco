package classe.output;
import java.util.Scanner;
import classe.entities.people.Cliente;
import classe.entities.accountModels.*;
import classe.input.*;
import java.time.LocalDate;
import classe.entities.bank.*;
import classe.relation.*;
import java.util.ArrayList;
import java.util.Random;
import classe.util.*;
import classe.data.Data;
import classe.entities.bank.services.Transacao;

//import classe.util.Endereco;
//inativar conta
public class Menu {
  // Display de menus e opcoes com 3 tipos de menus funcionario/cliente/admin
  // cliente -> realiza transacoes
  // funcionario -> realiza operacoes com clientes cria exclui atualiza inativa
  // admin -> realiza operacoes com funcionarios cria exclui atualiza
  
  
  

  
  
  
  
	
	
	

  public static void exibeMenu() {
	Scanner sc = new Scanner(System.in);
	Data dat = new Data();

	String pathTransacao ="/home/vinicius/Documentos/programacao/POO/Trabalho-final/oopFinalProject-main/src/classe/data/transacao.dat";
	String pathCliCon ="/home/vinicius/Documentos/programacao/POO/Trabalho-final/oopFinalProject-main/src/classe/data/clienteContaRelation.dat";
	String pathGerAgen ="/home/vinicius/Documentos/programacao/POO/Trabalho-final/oopFinalProject-main/src/classe/data/gerenteAgenciaRelation.dat";

	ArrayList<Transacao> transacaoEscrita = new ArrayList<>();
	ArrayList<ClienteConta> cliContaEscrita = new ArrayList<>();
	ArrayList<GerenteAgencia> gerAgenEscrita = new ArrayList<>();

	dat.lerClienteConta(pathCliCon);
	//dat.lerTransacao(pathTransacao);
	//dat.lerGerenteAgencia(pathGerAgen);
			

	double valor = 0.0;
	Random gerador = new Random();
	String initialOption;
	
	int numConta=0;
	String password=null;
	int option=0;
	
	
	
    System.out.println("--------- Bem-vindo ao Banco XXX ---------");
	do{
		System.out.println("- Você já possui uma conta cadastrada em nosso banco? (S/N)");
		initialOption = sc.nextLine();
		System.out.print("\033\143");
	}while(initialOption.equals("S") != true && initialOption.equals("N") != true);

    if (initialOption.equals("S")) {
		
		do{
			System.out.println("Qual o numero da conta?");
			numConta = sc.nextInt();
			sc.nextLine();
			System.out.println("Digite a senha: ");			
			password = sc.nextLine();
			System.out.print("\033\143");
		}while(dat.verificaEBuscaConta(numConta,password) == false);

		do{
			exibeOpcoesDaConta();
			option = sc.nextInt();
			
			System.out.print("\033\143");
			
		}while(option < 1 || option > 4);

		String canal[] = {"Caixa Fisico", "Caixa Eletronico", "Internet Banking"};	
		int ram = gerador.nextInt(3);
		sc.nextLine();
		Conta conta = dat.getConta();//joa saldo 10
		switch(option){
			case 1:
				Transacao saldoTransaction = new Transacao(conta,LocalDate.now(),canal[ram]);
				System.out.println("Digite a senha para prosseguir: ");
				password = sc.nextLine();		
				double saldo = saldoTransaction.consultarSaldo(password);
				System.out.printf("O saldo eh: %.2f\n",saldo);
				transacaoEscrita.add(saldoTransaction);
				Data.write(transacaoEscrita,pathTransacao);
				System.out.println("Transacao Concluida com sucesso");
				System.out.println("O canal foi: " + saldoTransaction.getCanal() + "\nNa data: " + saldoTransaction.getData());
				break;

			case 2:
				Transacao depositoTransaction = new Transacao(conta,LocalDate.now(),canal[ram]);
				System.out.println("Digite a senha para prosseguir: ");
				password = sc.nextLine();
				System.out.println("Digite o valor a ser depositado: (Digite apenas numeros)");
				valor = sc.nextDouble();
				if(depositoTransaction.deposito(valor,password)){
					System.out.println(depositoTransaction.getConta().getSaldoAtual());
					transacaoEscrita.add(depositoTransaction);
					Data.write(transacaoEscrita,pathTransacao);
					Data.write(dat.getCliCon(),pathCliCon);
					System.out.println("Transacao Concluida com sucesso");
					System.out.println("O canal foi: " + depositoTransaction.getCanal() + "\nNa data: " + depositoTransaction.getData());
				}
				else{
					System.out.println("O valor de deposito precisa ser maior que 0");
				}
				
				break;

			case 3:
				Transacao saqueTransaction = new Transacao(conta,LocalDate.now(),canal[ram]);
				System.out.println("Digite a senha para prosseguir: ");
				password = sc.nextLine();
				System.out.println("Digite o valor a ser sacado: (Digite apenas numeros)");
				valor = sc.nextDouble();
				if(saqueTransaction.saque(valor, password)){
					transacaoEscrita.add(saqueTransaction);
					Data.write(transacaoEscrita,pathTransacao);
					Data.write(dat.getCliCon(),pathCliCon);
					System.out.println("Transacao Concluida com sucesso");
					System.out.println("O canal foi: " + saqueTransaction.getCanal() + "\nNa data: " + saqueTransaction.getData());
				}
				else{
					System.out.println("Saldo insuficiente.");
				}
				break;
		
			case 4:
				Transacao pagamentoTransaction = new Transacao(conta,LocalDate.now(),canal[ram]);
				System.out.println("Digite a senha para prosseguir: ");
				password = sc.nextLine();
				System.out.println("Digite o valor do pagamento: (Digite apenas numeros)");
				valor = sc.nextDouble();
				if(pagamentoTransaction.efetuarPagamento(valor, password)){
					transacaoEscrita.add(pagamentoTransaction);
					Data.write(transacaoEscrita,pathTransacao);
					Data.write(dat.getCliCon(),pathCliCon);
					System.out.println("Transacao Concluida com sucesso");
					System.out.println("O canal foi: " + pagamentoTransaction.getCanal() + "\nNa data: " + pagamentoTransaction.getData());
				}
				else{
					System.out.println("Saldo insuficiente");
				}
				
				break;
		
  		}
	
	}	else {
			double rendimentoMes;
			int maxRandom = 9999;
			int accountOption = 0;
			int numGerado =gerador.nextInt(maxRandom)+1;//gera o numero da conta
			String opcao,senha;
		  Cliente cliente1 = null;
		  Cliente cliente2 = null;
		  Endereco enderecoAgencia = new Endereco("MG","Uberlandia", "Santa Monica", "R. Central", "1232", "38413648");
		  Agencia agencia = new Agencia(1,"Udia Agency",enderecoAgencia);
		  System.out.println("Vamos iniciar o processo de cadastro!");
		  do{
			System.out.println("Qual tipo de conta você deseja ter? (Digite o número da opção)");
			  System.out.println("1 - Conta Poupança"
			  + "\n2 - Conta Corrente"
			  + "\n3 - Conta Salário");
			accountOption = sc.nextInt();
			sc.nextLine();
			System.out.print("\033\143");
		  }while(accountOption < 1 || accountOption > 3);
		  
		  switch (accountOption) {
	
			case 1:
				do{
					System.out.println("A conta sera conjunta ?(S/N)");
					opcao = sc.nextLine();
					System.out.print("\033\143");
				}while(opcao.equals("S") != true && opcao.equals("N") != true);
					
					if(opcao.equals("S")){
			  
						System.out.println("Informe os dados do primeiro cliente");
						cliente1 = dataInput.dadosBasicos();
						System.out.println("Informe a nova senha da conta: ");
						senha = sc.nextLine();
						System.out.println("Informe o rendimento mensal da conta conjunta: ");
						rendimentoMes = sc.nextDouble();
						System.out.print("\033\143");
						System.out.println("Informe os dados do segundo cliente");
						cliente2 = dataInput.dadosBasicos();
						
						
						CPoupanca cp = new CPoupanca(numGerado,0,LocalDate.now(),1,true,agencia,senha,rendimentoMes);
						  ClienteConta cliCon = new ClienteConta(cliente1,cp);
						  ClienteConta cliCon2 = new ClienteConta(cliente2,cp);
						cliContaEscrita.add(cliCon);
						cliContaEscrita.add(cliCon2);
						Data.write(cliContaEscrita,pathCliCon);
						System.out.printf("Conta cadastrada com sucesso, o numero da conta eh: %d\n",numGerado);
						//exibeOpcoesDaConta();
						//carregar do arquivo o nro de conta anterior, somar +1 e instanciar com esse nro.
						
					}
					else{
						cliente1 = dataInput.dadosBasicos();
						System.out.println("Informe a nova senha da conta: ");
						senha = sc.nextLine();
						System.out.println("Informe o seu rendimento mensal: ");
						rendimentoMes = sc.nextDouble();
						CPoupanca cp = new CPoupanca(numGerado,0,LocalDate.now(),1,false,agencia,senha,rendimentoMes);
						ClienteConta cliCon = new ClienteConta(cliente1,cp);
						cliContaEscrita.add(cliCon);
						Data.write(cliContaEscrita,pathCliCon);
						System.out.printf("Conta cadastrada com sucesso, o numero da conta eh: %d\n",numGerado);
						//exibeOpcoesDaConta();
						//carregar do arquivo o nro de conta anterior, somar +1 e instanciar com esse nro.
						
					}System.out.println("Conta cadastrada com sucesso");
					break;
					
				case 2:
					do{
						System.out.println("A conta sera conjunta ?(S/N)");
						opcao = sc.nextLine();
						System.out.print("\033\143");
					}while(opcao.equals("S") != true && opcao.equals("N") != true);
					if(opcao.equals("S")){
						System.out.println("Informe os dados do primeiro cliente");
						cliente1 = dataInput.dadosBasicos();
						System.out.println("Informe a nova senha da conta: ");
						senha = sc.nextLine();
	
						System.out.println("Informe os dados do segundo cliente");
						cliente2 = dataInput.dadosBasicos();
						CCorrente cc = new CCorrente(numGerado,0,LocalDate.now(),1,true,agencia,senha);
						ClienteConta cliCon = new ClienteConta(cliente1,cc);
						ClienteConta cliCon2 = new ClienteConta(cliente2,cc);
						cliContaEscrita.add(cliCon);
						cliContaEscrita.add(cliCon2);
						Data.write(cliContaEscrita,pathCliCon);
						System.out.printf("Conta cadastrada com sucesso, o numero da conta eh: %d\n",numGerado);
						//exibeOpcoesDaConta();
						//carregar do arquivo o nro de conta anterior, somar +1 e instanciar com esse nro.
					}
					else{
						cliente1 = dataInput.dadosBasicos();
						System.out.println("Informe a nova senha da conta: ");
						senha = sc.nextLine();
						CCorrente cc = new CCorrente(numGerado,0,LocalDate.now(),1,false,agencia,senha);
						ClienteConta cliCon = new ClienteConta(cliente1,cc);
						cliContaEscrita.add(cliCon);
						Data.write(cliContaEscrita,pathCliCon);
						System.out.printf("Conta cadastrada com sucesso, o numero da conta eh: %d\n",numGerado);	
						//exibeOpcoesDaConta();
						System.out.println("Deseja ir para as opcoes da conta ?: ");
						sc.nextLine();
						opcao = sc.nextLine();
						//carregar do arquivo o nro de conta anterior, somar +1 e instanciar com esse nro.
					}
				break;	
				case 3:
			  	cliente1 = dataInput.dadosBasicos();				
				System.out.println("Informe a nova senha da conta: ");
				senha = sc.nextLine();
				CSalario cs = new CSalario(numGerado,0,LocalDate.now(),1,false,agencia,senha);
				ClienteConta cliCon = new ClienteConta(cliente1, cs);
				cliContaEscrita.add(cliCon);
				Data.write(cliContaEscrita,pathCliCon);
				System.out.printf("Conta cadastrada com sucesso, o numero da conta eh: %d\n",numGerado);
				//exibeOpcoesDaConta();
				//carregar do arquivo o nro de conta anterior, somar +1 e instanciar com esse nro.
				break;
			}
		}
	}

  public static void exibeOpcoesDaConta(){
  

	System.out.println("Selecione uma das opcoes: ");
			System.out.println("1 - Consultar saldo");
			System.out.println("2 - Realizar deposito");
			System.out.println("3 - Realizar saque");
			System.out.println("4 - Efetuar pagamento");
			
   

  }

  
	
	
	
}
// System.out.print("\033\143");//limpa tela