package classe.data;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import classe.relation.*;
import classe.entities.bank.services.Transacao;
import classe.entities.accountModels.Conta;
public class Data implements Serializable{
  private ArrayList<ClienteConta> cliCon;
  private ArrayList<GerenteAgencia> gerAgen;
  private ArrayList<Transacao> transacao;
  private Conta conta; 
  //como atualizar um dado do cliente
  /*
  //trabalhar com lista
  1-> Carrega o arquivo em uma variável
  2-> Acha a posição do registro do cliente no vetor
  3-> Setar o parametro novo do cliente ou conta
  3-> Nessa mesma posição sobrepor com a nova classe atualizada
  4-> Subir o arquivo novamente
  */
    ///home/vinicius/Documentos/programacao/POO/Trabalho-final/oopFinalProject-main/src/classe/data
    public Data(){

    }

    public ArrayList<ClienteConta> getCliCon(){
      return this.cliCon;
    }

    public ArrayList<GerenteAgencia> getGerAgen(){
      return this.gerAgen;
    }

    public Conta getConta(){
      return conta;
    }

    public void setConta(Conta conta){
      this.conta = conta;
    }


    public static void writeA(Object obj,String path){
      //Escreve em modo de append o obj de parametro no arquivo
      try{
        FileOutputStream arq= new FileOutputStream(path,true);
        ObjectOutputStream os= new ObjectOutputStream(arq);
        os.writeObject(obj);
        os.close();
      } catch (IOException erro){
        System.out.println(erro.getMessage());
      } 
    }

    public static void write(Object obj,String path){
      //Sobrescreve o que tinha no arquivo com o objeto de parametro
      try{
        FileOutputStream arq= new FileOutputStream(path);
        ObjectOutputStream os= new ObjectOutputStream(arq);
        os.writeObject(obj);
        os.close();
        arq.close();
      } catch (IOException erro){
        System.out.println(erro.getMessage());
      }
        
    }
  
    public void lerGerenteAgencia(String path){
      //Lê o arquivo e escreve no objeto de parametro
      try{
        FileInputStream arq = new FileInputStream(path);
        ObjectInputStream is = new ObjectInputStream(arq);
        //System.out.println(leitura.get(0));
        //System.out.println(leitura.get(1));
        gerAgen = (ArrayList<GerenteAgencia>)is.readObject();
        System.out.println(gerAgen.size());
        is.close();
        arq.close();
      } catch(IOException erro){
        System.out.println(erro.getMessage());
      } catch(ClassNotFoundException erro){
        System.out.println("Classe não encontrada");
      }
    }

    public void lerClienteConta(String path){
      //Lê o arquivo e escreve no objeto de parametro
      try(FileInputStream arq = new FileInputStream(path);
      ObjectInputStream is = new ObjectInputStream(arq)){
        cliCon = (ArrayList<ClienteConta>) is.readObject(); 
      } catch(IOException erro){
        System.out.println(erro.getMessage());
      } catch(ClassNotFoundException erro){
        System.out.println("Classe não encontrada");
      }
    }

    public void lerTransacao(String path){
      //Lê o arquivo e escreve no objeto de parametro
      try(FileInputStream arq = new FileInputStream(path);
      ObjectInputStream is = new ObjectInputStream(arq)){
        transacao = (ArrayList<Transacao>) is.readObject();
      } catch(IOException erro){
        System.out.println(erro.getMessage());
      } catch(ClassNotFoundException erro){
        System.out.println("Classe não encontrada");
      }
    }

    private static void update(Conta conta){
      
    

    }

    public boolean verificaEBuscaConta(int num,String senha){
      for(ClienteConta cli : getCliCon()){
        if(cli.getConta().getNumConta() == num && cli.getConta().getSenha().equals(senha)){
          setConta(cli.getConta());
          return true;
        }
      }
      return false; 
    }
}