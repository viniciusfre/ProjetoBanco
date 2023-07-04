package classe.main;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import classe.entities.people.*;
import classe.util.*;
import classe.entities.bank.*;
import classe.relation.*;
import java.util.ArrayList;
import classe.data.Data;
public class MainAgenciaGerente {
    public static void main(String[] args){
        Data dat = new Data();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList <GerenteAgencia> gerenteAgencia = new ArrayList<>();
        //Gerente 1
        Endereco endereco = new Endereco("MG","Uberlandia", "Luizote", "R. Jose Fonseca", "1125", "38414294");
        Gerente gerente = new Gerente("Carlos","34066066011" , LocalDate.parse("11/11/1981",formatter), "Casado", endereco, 123, "MG22555","Masculino", "Gerente Pleno", 7.000, 
        LocalDate.parse("01/01/2007",formatter), LocalDate.parse("25/03/2006",formatter),true);

        //Gerente 2
        Endereco endereco2 = new Endereco("MG","Uberlandia", "Luizote", "R. Jose Fonseca", "1125", "38414294");
        Gerente gerente2 = new Gerente("Claudio","3568066015" , LocalDate.parse("28/04/1977",formatter), "Solteiro", endereco2, 123, "MG23887","Masculino", "Gerente Senior", 10.000, 
        LocalDate.parse("01/07/2003",formatter), LocalDate.parse("07/06/2006",formatter),true);

        //Agencia 1
        Endereco enderecoAgencia = new Endereco("MG","Uberlandia", "Santa Monica", "R. Central", "1232", "38413648");
        Agencia agencia = new Agencia(1,"Udia Agency",enderecoAgencia);

        //Agencia 2
        Endereco enderecoAgencia2 = new Endereco("MG","Uberlandia", "Planalto", "R. Genova", "7512", "38411246");
        Agencia agencia2 = new Agencia(1,"Udia Agency 2",enderecoAgencia2);

        //Relação GerenteAgencia
        GerenteAgencia gerAge = new GerenteAgencia(gerente, agencia);
        GerenteAgencia gerAge2 = new GerenteAgencia(gerente2, agencia2);
        gerenteAgencia.add(gerAge);
        gerenteAgencia.add(gerAge2);
        Data.write(gerenteAgencia,"/home/vinicius/Documentos/programacao/POO/Trabalho-final/oopFinalProject-main/src/classe/data/gerenteAgenciaRelation.dat");
        dat.lerGerenteAgencia("/home/vinicius/Documentos/programacao/POO/Trabalho-final/oopFinalProject-main/src/classe/data/gerenteAgencia.dat");
        
    }
}
